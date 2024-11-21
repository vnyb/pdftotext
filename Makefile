docker: pdftotext.jar pdftotext
	docker build -t pdftotext .

jar: pdftotext.jar

pdftotext.jar:
	mvn clean package
	cp target/pdftotext.jar $@

clean:
	rm -f pdftotext.jar
	mvn clean
	
