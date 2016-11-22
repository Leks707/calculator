Simple calculator for integer numbers with operations: plus, minus, division, multiply and raising to a power.
Calculator also supports brackets and priority of operations. Has simple web service and client with JAX-WS.

## Installation

    Requirement software:
        JDK 1.8
        maven 3.3
    Open console and use command:
        mvn clean install

## Usage

    1. Going to the target folder and use command for run server:
        java -jar calculator-1.0-SNAPSHOT.jar
    2. Open new console in target folder and use command for run client:
        java -cp calculator-1.0-SNAPSHOT.jar com.aleks.client.ClientRunner ${mathStatement}
        Where ${mathStatement} is string mathematical sequence,
        for example -1+2-3*(3+1)^2

        After that you must see the RESULT: ${some_number}
        Where ${some_number} is the result of mathematical statement.

## Contributing

If you have git installed, you now clone git repo using the following command-line:
    git clone https://github.com/Leks707/calculator.git
    and work with code.

## License

Copyright (c)2016 alekseyshylo@gmail.com
