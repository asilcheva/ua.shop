# docker build -t java_tc_counter .

FROM b359888d8aa2

WORKDIR /tests

COPY . .

CMD gradle test --tests "FilterBrandTest.filteredSamsungBrandIsCheckedTest"