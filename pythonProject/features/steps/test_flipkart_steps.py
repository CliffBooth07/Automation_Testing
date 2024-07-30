from behave import given, when, then
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.common.keys import Keys
from jproperties import Properties
import time

@given('the user is on the Flipkart homepage')
def step_user_on_homepage(context):
    configs = Properties()
    with open("config.properties", "rb") as file:
        configs.load(file)
    context.driver = webdriver.Chrome()
    context.driver.get(f'{configs.get("link").data}')
    context.driver.maximize_window()
    context.wait = WebDriverWait(context.driver, 10)
    current_url = context.driver.current_url
    assert current_url == "https://www.flipkart.com/", "Wrong Page"

@when('the user searches for a product')
def step_user_searches_product(context):
    configs = Properties()
    with open("config.properties", "rb") as file:
        configs.load(file)
    search_bar = context.wait.until(ec.presence_of_element_located((By.XPATH,
        "//div[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")))
    search_bar.click()
    search_bar.send_keys(f'{configs.get("item").data}')
    search_bar.send_keys(Keys.RETURN)
    context.results_found = context.wait.until(ec.presence_of_element_located(
        (By.XPATH, "//div[@id='container']/div/div[3]/div[1]/div[2]/div[1]/div/div/span")))

@then('the search results should be displayed')
def step_search_results_displayed(context):
    assert context.results_found is not None, "No results found"
    print(context.results_found.text)
    context.product_found = context.driver.find_elements(By.CLASS_NAME, "KzDlHZ")
    with open("result_found.txt", "w") as file:
        for product in context.product_found:
            print(product.text)
            file.writelines(product.text + "\n")

@then('the user adds the product to the cart')
def step_add_product_to_cart(context):
    window_before = context.driver.current_window_handle
    context.driver.find_element(By.XPATH, "//div[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a").click()
    time.sleep(3)
    for handle in context.driver.window_handles:
        if handle != window_before:
            window_after = handle
            break
    context.driver.switch_to.window(window_after)
    product_name = context.wait.until(ec.presence_of_element_located(
        (By.XPATH, "//div[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span")))
    print(product_name.text)
    add_to_cart = context.driver.find_element(By.XPATH,
        "//div[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
    assert add_to_cart.is_displayed(), "Add to cart button not displayed"
    context.driver.find_element(By.XPATH, "//div[@id='container']/div/div[1]/div[1]/div[2]/div[1]/div/a[1]").click()
    context.driver.implicitly_wait(3)
    try:
        context.driver.find_element(By.XPATH,
            '//div[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div').click()
    except:
        context.driver.implicitly_wait(4)
        print("Pop up showed")
        context.driver.find_element(By.XPATH, "/html/body/div[3]/div/span").click()
        context.driver.find_element(By.XPATH,
            '//div[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div').click()
    time.sleep(4)
    context.driver.quit()
