# hellomybatis


```shell
curl -XPOST -H "Content-Type:application/json" "http://localhost:10004/v1/tree/created" -d '{
	"body":[
		{
			"id": "1",
			"pid": "0",
			"name": "dir1"
		},
		{
			"id": "2",
			"tagId": "tagA",
			"count": 3000,
			"name": "tagA",
			"pid": "1"
		}
	]
}' | jq .
```
