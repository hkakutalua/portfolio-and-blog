<img src="avatar.svg" width=300px />

# My Blog and Portfolio
This repository contains the source code for [my personal website](kakutalua.herokuapp.com).

## Contributing

Please feel welcome to contribute to this repository, you can send an issue if there's an interesting feature to be added or a bug you spot.

You can also send pull request if you want to add features or solve bugs yourself. Please send small and focused changes to make the reviews easier.

## Prerequisites and Tools

- JDK 1.8 and above.
- Maven 3.0 and above.

### Configure Dependencies

If you are using Windows, we recommend you using [Chocolatey](https://chocolatey.org/install) package manager to make the installing of tools and dependencies straightforward.

- Open Windows PowerShell as an administrator and execute the following command:

  ```
  Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
  ```

Install Maven on Windows

```
choco install maven
```

Install Maven on Ubuntu

```
sudo apt install maven
```

### Install PostgreSQL 12

To install on Windows using Chocolatey (otherwise download it [here](https://www.postgresql.org/download/windows/)):

```
choco install postgresql12
```

To install on Ubuntu (Focal), add the Focal repository to `etc/apt/sources.list.d/pgdg.list`

```
deb http://apt.postgresql.org/pub/repos/apt/ focal-pgdg main
```

Import the repository signing key:

```
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update
```

And install PostgreSQL 12 with pgAdmin:

```
sudo apt install postgresql-12 pgadmin4
```

### Environment Variables

| Variable                         | Description                           | Possible Values |
| -------------------------------- | ------------------------------------- | --------------- |
| SPRING_PROFILE                   | Current application environment       | dev, prod, test |
| WEB_APPLICATION_PG_HOST          | The hostname of the PostgreSQL server |                 |
| WEB_APPLICATION_PG_DATABASE_NAME | The database name of the application  |                 |
| WEB_APPLICATION_PG_USERNAME      | The username of the PostgreSQL server |                 |
| WEB_APPLICATION_PG_PASSWORD      | The password of the PostgreSQL server |                 |

Don't forget to create the database for the application and set the **WEB_APPLICATION_PG_DATABASE_NAME** variable to its name, before running the application
## Build and Execute the Application

To build the application, go to the project's root directory and type:

```
mvn compile
```

To run:

```
mvn spring-boot:run
```

