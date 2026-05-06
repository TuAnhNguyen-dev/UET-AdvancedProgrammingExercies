#!/bin/bash

# Cross-Platform File Path Handling Demo - run.sh
# This script demonstrates cross-platform path handling in Java

cd "$(dirname "$0")"

echo "========================================"
echo "Bài 4: Cross-Platform File Path Handling"
echo "========================================"
echo ""
echo "Operating System: $(uname -s)"
echo "Java Version: $(java -version 2>&1 | head -1)"
echo ""

# Navigate to project root
PROJECT_ROOT="$(cd ../../.. && pwd)"
cd "$PROJECT_ROOT"

echo "=== Running Main Demo ==="
mvn clean compile exec:java -Dexec.mainClass="bai04.Main" -q

echo ""
echo "=== Running Unit Tests ==="
mvn test -Dtest=bai04.FilePathTest -v

echo ""
echo "========================================"
echo "✅ Demo completed!"
echo "========================================"

