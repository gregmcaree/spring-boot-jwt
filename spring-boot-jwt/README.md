source:

https://medium.com/swlh/spring-boot-security-jwt-hello-world-example-b479e457664c


curl:
curl -d '{"username": "user", "password": "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6"}' -H "Content-Type: application/json" -X POST http://localhost:8080/authenticate

curl -H 'Accept: application/json' -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTc1NTgyMzM0LCJpYXQiOjE1NzU1NjQzMzR9.qr1nTkXchWlFmNUa3mkuGhMErSeZ1vB60P1JB1QquR6faI8tDr6nLnUVX6jz7Dewp2zGPcNcouTJrS77zmD5tg" http://localhost:8080/hello
