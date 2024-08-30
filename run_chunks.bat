@echo off

for /L %%i in (1,1,16) do (
    REM Calculate the port number (8080 + %%i)
    setlocal enabledelayedexpansion
    set /A port=8080+%%i

    REM Run Docker container for each chunk
    docker run -d ^
    --name pi_service_of_16_container_%%i ^
    -p !port!:8080 ^
    -e CHUNK_FILE=/app/chunks/master_file_chunk%%i.txt ^
    pi-service16

    endlocal
)
