rm -rf out/*;
javac -cp "src" -d out src/app/LabelPrinter.java && cd ./out && java app/LabelPrinter -lf $*