import pytest
from selenium import webdriver


@pytest.fixture(params=["chrome","edge"])
def driver(request):
    print("Starting Tests")
    browser=request.param
    if browser=="chrome":
        mydriver = webdriver.Chrome()
    elif browser=="edge":
        mydriver= webdriver.Edge()

    yield mydriver
    print("Completed All process")
    mydriver.quit()
