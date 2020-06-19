# Test Task

Test framework is based on:

  - Gradle
  - Selenide
  - JUnit5
  - Allure

# To run tests execute gradle command

  ```sh
$ gradle clean test
```

You can also generate Allure report after tests execution, just execute next command:
 ```sh
$ gradle allureReport
```
> Then open generated report location and *index.html* file in any browser

### Test flow

* Open [Sportmaster]
* Click location link in header
* Search for some city
* Select autocomplete suggestions
* Confirm action
* Check new location is displayed on Home page

## Enjoy! =)

   [Sportmaster]: <https://www.sportmaster.ru/>

