--
-- Created by IntelliJ IDEA.
-- User: tank198435163.com
-- Date: 2019-04-09
-- Time: 22:35
-- To change this template use File | Settings | File Templates.
--

local disCode = ""
local requirement = {}

for k, v in pairs(KEYS)
do
    if (v == 'dis') then
        disCode = ARGV[k]
    else
        requirement[v] = ARGV[k]
    end
end

disCode = 'dis:' .. disCode

for k, v in pairs(requirement) do
    local current = redis.call("hget", disCode, k)
    if (v + 0 > current + 0) then
        return k
    end
end

for k, v in pairs(requirement) do
    local current = redis.call("hget", disCode, k)
    local diff = (current + 0) - (v + 0)
    redis.call('hset', disCode, k, diff)
end


return 'success'

