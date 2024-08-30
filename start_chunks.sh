#!/bin/bash


for i in {1..16}; do

  docker start pi_service_of_16_container_$i


  if [ $? -eq 0 ]; then
    echo "Successfully started pi-service$i"
  else
    echo "Failed to start pi_service_chunk_$i"
  fi
done
