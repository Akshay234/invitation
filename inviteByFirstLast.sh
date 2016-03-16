rm -rf out/*;
javac -cp "src" -d out src/LabelPrinter.java && cd ./out && java LabelPrinter -fl $*