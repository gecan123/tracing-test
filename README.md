# tracing-test
Run the unit test `[ErrorControllerApiTest.java]`. All the test cases should have traceId response, but some do NOT have.

I have ran test by github actions, reports refer to the artifacts in https://github.com/gecan123/tracing-test/actions/runs/5528319390, test result is at `/reports/tests/test/index.html`.

However, the same test scenarios at spirngboot2 + sleuth, the traceId remains.
