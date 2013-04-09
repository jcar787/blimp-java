# blimp-java

This library allows you to interact with the Blimp API using Java. You can find more information
about Blimp's Public API documentation at [http://dev.getblimp.com/](http://dev.getblimp.com/).
If you have any problems or requests please contact [support](mailto:support@blackbyte.biz?subject=Blimp API Java library).

## License
Licensed under the MIT License.

## Install

Using Github:

```
git clone git@github.com:blackone787/blimp-java
````

## Pre-Usage

Before we begin using the library you need to signup to [Blimp](http://app.getblimp.com/) and generate a new API Key if you don't have one in your [settings](https://app.getblimp.com/user/settings/api/) as well as an Application ID and Secret in your [applications](https://app.getblimp.com/user/settings/api/developers/).
Also if you are goig to use the library for desktop development you must first download org.json source or jar and add it to your buildpath.

## Usage

```java
// TODO =]
```

### Example response of all companies I'm part of
```JSON
{
    "meta": {
        "limit": 20,
        "next": null,
        "offset": 0,
        "previous": null,
        "total_count": 1
    },
    "objects": [
        {
            "company_users": [
                {
                    "accepted_invitation": true,
                    "date_created": "2012-11-01T00:00:00",
                    "date_modified": "2012-11-27T02:22:09.817265",
                    "id": 38,
                    "is_active": true,
                    "role": "admin",
                    "user": "/api/v2/user/3/"
                },
                {
                    "accepted_invitation": true,
                    "date_created": "2012-11-01T00:00:00",
                    "date_modified": "2012-11-27T02:22:09.705959",
                    "id": 37,
                    "is_active": true,
                    "role": "admin",
                    "user": "/api/v2/user/2/"
                },
                {
                    "accepted_invitation": true,
                    "date_created": "2012-11-01T00:00:00",
                    "date_modified": "2012-11-27T02:22:09.380851",
                    "id": 39,
                    "is_active": true,
                    "role": "owner",
                    "user": "/api/v2/user/1/"
                }
            ],
            "date_created": "2012-11-01T00:00:00",
            "date_modified": "2012-12-21T21:57:09.965247",
            "id": 1,
            "image_url": "",
            "name": "Blimp",
            "resource_uri": "/api/v2/company/1/",
            "slug": "blimp",
            "used_projects": 0,
            "used_storage": "4929882"
        }
    ]
}
```
### Todo
* Tests