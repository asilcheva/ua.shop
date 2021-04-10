# docker build -t java_tc_counter .

FROM gradle:jdk11

WORKDIR /tests

COPY . .

CMD gradle test --tests "FilterBrandTest.filteredSamsungBrandIsCheckedTest"