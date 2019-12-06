# AE-Parser
AE File Format Parser Writed in Java, currently the AE Format is in the first version. And Currently is not able to a stable use.

The AE File format was designed having json as model, but it accept attributes inside the AE elements.
```
["key":
    ["key":
        ["key":"value1" 'attr 1'='attr value 1' 'attr 2'='attr value 2'],
        ["key":
            ["key":
                ["key":"value" 'attr 1'='attr value 1'],
                ["key":"value"]
            'attr 1'='attr value 1' ],
            ["key":
                ["key":"value 1"]
            ]
        ]
    ],
    ["key":"value"] 
]
```
