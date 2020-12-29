# ElasticSearch

## 商品サジェスト

### インデックス設定
インデックスの設定ファイル(product-suggest-index-config.json)を指定して作成

```shell script
curl --location --request PUT 'http://localhost:9200/products' \
--header 'Content-Type: application/json' \
--data-raw '{
  "settings": {
    "analysis": {
      "tokenizer": {
        "ngram_custom_tokenizer": {
          "type": "ngram",
          "min_gram": 2,
          "max_gram": 2
        },
        "edge_ngram_custom_tokenizer": {
          "type": "edge_ngram",
          "min_gram": 2,
          "max_gram": 13
        }
      },
      "analyzer": {
        "ngram_custom_analyzer": {
          "type": "custom",
          "tokenizer": "ngram_custom_tokenizer"
        },
        "edge_ngram_custom_analyzer": {
          "type": "custom",
          "tokenizer": "edge_ngram_custom_tokenizer"
        }
      }
    }
  },
  "mappings": {
    "properties": {
      "id": {
        "type": "keyword"
      },
      "shopId": {
        "type": "keyword"
      },
      "productName": {
        "type": "text",
        "analyzer": "ngram_custom_analyzer"
      },
      "janCode": {
        "type": "text",
        "analyzer": "edge_ngram_custom_analyzer"
      }
    }
  }
}'
```

### 作成したインデックスの確認
```bash
$ curl --location --request GET 'http://localhost:9200/products'
```

### サンプルの追加
products.shを実行

### 検索
検索は下記のようなリクエストを想定。

検索するキーワードはjanコード、商品名で共通なので同じキーワードを `should` で指定する
また、janコードは前方一致となる

商品名で検索
```shell script
curl --location --request GET 'http://localhost:9200/products/_search' \
--header 'Content-Type: application/json' \
--data-raw '{
    "query": {
        "bool": {
            "must": [
                {"term": {"shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ"}}
            ],
            "should": [
                {"match": {"janCode": "フルクトン"}},
                {"match": {"productName": "フルクトン"}}
            ]
        }
    },
    "size": 10
}'
```

レスポンス
```json
{
    "took": 9,
    "timed_out": false,
    "_shards": {
        "total": 1,
        "successful": 1,
        "skipped": 0,
        "failed": 0
    },
    "hits": {
        "total": {
            "value": 32,
            "relation": "eq"
        },
        "max_score": 22.129248,
        "hits": [
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "O4xS93QBtTrryloVKwK0",
                "_score": 22.129248,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXCXY91PE2R6YTPEWQ6",
                    "janCode": "4987035182610",
                    "productName": "１０％フルクトン注"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "SYxS93QBtTrryloVLQLY",
                "_score": 15.665646,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XYGXEDXBWRWWP0ZNT9T",
                    "janCode": "4987035182917",
                    "productName": "フルクトマニト注"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "SoxS93QBtTrryloVLgIB",
                "_score": 2.475047,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XYK1A0AKCW8XV0SJ1F7",
                    "janCode": "4987770520302",
                    "productName": "フルベアンコーワテープ８μｇ／ｃｍ２"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "PIxS93QBtTrryloVKwLV",
                "_score": 0.6931472,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXE1HS72HCMJ9T3JFZ4",
                    "janCode": "4987123112567",
                    "productName": "２５ｍｇアリナミンＦ糖衣錠"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "PYxS93QBtTrryloVKwL_",
                "_score": 0.6931472,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXHC8ZYBVKHQ644NEH3",
                    "janCode": "4987123063616",
                    "productName": "５０ｍｇアリナミンＦ糖衣錠"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "PoxS93QBtTrryloVLAIu",
                "_score": 0.6931472,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXNYVCFQHPBDY67RXTY",
                    "janCode": "4987123103459",
                    "productName": "５ｍｇアリナミンＦ糖衣錠"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "P4xS93QBtTrryloVLAJF",
                "_score": 0.6931472,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXQAWRK7GCG3X7D0DHP",
                    "janCode": "4987188491225",
                    "productName": "Ｌ－キサール顆粒５００"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "QIxS93QBtTrryloVLAJq",
                "_score": 0.6931472,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXSJD8RZ5F1XM0TNMTS",
                    "janCode": "4987123005265",
                    "productName": "アリナミンＦ１００注"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "QYxS93QBtTrryloVLAKf",
                "_score": 0.6931472,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXW00MN16ME798GGTEH",
                    "janCode": "4987123005159",
                    "productName": "アリナミンＦ１０注"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "QoxS93QBtTrryloVLALF",
                "_score": 0.6931472,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXYTKDPSV39MJYEBC9B",
                    "janCode": "4987123005197",
                    "productName": "アリナミンＦ２５注"
                }
            }
        ]
    }
}
```

Janコードで検索
```json
{
    "query": {
        "bool": {
            "must": [
                {"term": {"shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ"}}
            ],
            "should": [
                {"match": {"janCode": "49877705203"}},
                {"match": {"productName": "49877705203"}}
            ]
        }
    },
    "size": 10
}
```

レスポンス
```json
{
    "took": 25,
    "timed_out": false,
    "_shards": {
        "total": 1,
        "successful": 1,
        "skipped": 0,
        "failed": 0
    },
    "hits": {
        "total": {
            "value": 32,
            "relation": "eq"
        },
        "max_score": 20.15019,
        "hits": [
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "SoxS93QBtTrryloVLgIB",
                "_score": 20.15019,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XYK1A0AKCW8XV0SJ1F7",
                    "janCode": "4987770520302",
                    "productName": "フルベアンコーワテープ８μｇ／ｃｍ２"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "RYxS93QBtTrryloVLQI0",
                "_score": 10.3759,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XY5DN9SZXF60QWSSH97",
                    "janCode": "4987770586704",
                    "productName": "コメリアンコーワ顆粒"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "S4xS93QBtTrryloVLgIZ",
                "_score": 2.3649719,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XYN3SEJP88JN6QX93NF",
                    "janCode": "4987758600477",
                    "productName": "ペントシリン筋注用"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "TIxS93QBtTrryloVLgI-",
                "_score": 2.3649719,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XYRBZ4ZZ1XAJBKEBE4M",
                    "janCode": "4987758600453",
                    "productName": "ペントシリン注射用１ｇ"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "TYxS93QBtTrryloVLgJx",
                "_score": 2.3649719,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XYT2Q22JWSY2SSKVZ4G",
                    "janCode": "4987758600460",
                    "productName": "ペントシリン注射用２ｇ"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "T4xS93QBtTrryloVLgLL",
                "_score": 2.3649719,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XYZZEEDD1KCR1MSBC80",
                    "janCode": "4987758065023",
                    "productName": "メタルカプターゼカプセル１００ｍｇ"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "O4xS93QBtTrryloVKwK0",
                "_score": 0.7163133,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXCXY91PE2R6YTPEWQ6",
                    "janCode": "4987035182610",
                    "productName": "１０％フルクトン注"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "PIxS93QBtTrryloVKwLV",
                "_score": 0.7163133,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXE1HS72HCMJ9T3JFZ4",
                    "janCode": "4987123112567",
                    "productName": "２５ｍｇアリナミンＦ糖衣錠"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "PYxS93QBtTrryloVKwL_",
                "_score": 0.7163133,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXHC8ZYBVKHQ644NEH3",
                    "janCode": "4987123063616",
                    "productName": "５０ｍｇアリナミンＦ糖衣錠"
                }
            },
            {
                "_index": "products",
                "_type": "_doc",
                "_id": "PoxS93QBtTrryloVLAIu",
                "_score": 0.7163133,
                "_source": {
                    "shopId": "01E1BF2XSB9E1SBGEGHNRK4KPZ",
                    "id": "01E1BF2XXNYVCFQHPBDY67RXTY",
                    "janCode": "4987123103459",
                    "productName": "５ｍｇアリナミンＦ糖衣錠"
                }
            }
        ]
    }
}
```