# DMR Command Line Tool

Small DMR related tool which reads a DMR encoded file from stdin and prints the base64 encoded version to stdout. Used by HAL to consume arbitrary resource descriptions. Since the DMR parsing is not available in HAL (due to GWT restrictions) only base64 encoded resource descriptions can be used.
 
Say you have a file `endpoint.dmr`

```
{
    "description" => "A definition of a management endpoint.",
    "attributes" => {
        "name" => {
            "type" => STRING,
            "description" => "The name of the management endpoint",
            "nillable" => false
        },
        "scheme" => {
            "type" => STRING,
            "description" => "The scheme of management endpoint. Allowed values are \"http\" and \"https\".",
            "nillable" => false,
            "allowed" => [
                "http",
                "https"
            ]
        },
        "host-name" => {
            "type" => STRING,
            "description" => "The hostname of the management endpoint",
            "nillable" => false
        },
        "port" => {
            "type" => INT,
            "description" => "The port of the management endpoint. Leave empty for the default ports.",
            "nillable" => true,
            "min" => 1L,
            "max" => 65535L
        }
    }
}
```

you can save the base64 encoded version by running

```bash
java -jar target/dmr-cmd-0.0.1.jar < endpoint.dmr > endpoint.base64 
```
