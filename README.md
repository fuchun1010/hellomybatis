# hellomybatis


> 注意需要先启动tag-service

```shell
curl -XPOST -H "Content-Type:application/json" "http://localhost:10004/v1/tree/created" -d '{
	"body":[
		{
			"id": "1",
			"pid": null,
			"name": "dir1"
		},
		{
			"id": "2",
			"tagId": "tagA",
			"name": "tagA",
			"pid": "1"
		}
	]
}' | jq .
```

```shell
curl -XGET -H "Content-Type:application/json" "http://localhost:10004/v1/tree" | jq .
```
