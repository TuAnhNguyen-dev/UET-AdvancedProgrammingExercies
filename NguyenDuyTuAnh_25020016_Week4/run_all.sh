#!/bin/bash

for i in {1..10}; do
  dir=Bai$(printf "%02d" $i)
  echo "===== $dir ====="
  (cd $dir && bash run.sh)
  echo ""
done
