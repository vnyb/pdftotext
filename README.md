# pdftotext

PDF-to-text tool

## Build JAR

Requires Maven.

```bash
make jar
```

## Run

```bash
# Convert PDF document to text
./pdftotext <path/to/document.pdf>

# Convert only one page
./pdftotext <path/to/document.pdf> <page number>
```

## Build docker image

```bash
make docker
```

## Run docker image

```bash
# Convert PDF file to text
docker run --rm -v <path/to/document.pdf>:/app/input.pdf pdftotext

# Convert only one page
docker run --rm -v <path/to/document.pdf>:/app/input.pdftotext pdftotext <page number>
```
