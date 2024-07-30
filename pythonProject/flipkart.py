from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()


class Flipkart:
    def function_tracker(fx):
        def mfx(*args, **kwargs):
            print("----------------------------------------")
            fx(*args, *kwargs)
            print("----------------------------------------")
        return mfx

    @function_tracker
    def test_open_url(self, url):
        driver.get(url)
        time.sleep(8)
        current_url = driver.current_url
        print(current_url)
        assert current_url == "https://www.flipkart.com/", "Wrong Page"
        print(url == current_url)

    @function_tracker
    def test_search_item(self, item):
        search_bar = driver.find_element(By.XPATH,"//div[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")
        search_bar.click()
        search_bar.send_keys(item + Keys.RETURN)
        time.sleep(10)

        results_found = driver.find_element(By.XPATH,'//div[@id="container"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span')
        print(results_found.text)

        product_found = driver.find_elements(By.CLASS_NAME, "KzDlHZ")
        file = open("result_found.txt", "w")
        for product in product_found:
            print(product.text)
            file.writelines(product.text + "\n")
        file.close()

    @function_tracker
    def test_add_cart(self):
        window_before = driver.current_window_handle
        print("Before: " + window_before)
        driver.find_element(By.XPATH, "//div[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a").click()
        time.sleep(3)
        for handle in driver.window_handles:
            if handle != window_before:
                print(handle)
                window_after = handle
                break
        print("After: " + window_after)
        driver.switch_to.window(window_after)
        time.sleep(3)
        product_name = driver.find_element(By.XPATH,"//div[@id='container']/div/div[3]/div[1]/div[2]/div[3]/div/div[1]/h1/span")
        print(product_name.text)
        add_to_cart = driver.find_element(By.XPATH,"//div[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
        assert add_to_cart.is_displayed(), "It not got displayed"

    @function_tracker
    def test_go_home(self):
        driver.find_element(By.XPATH, "//div[@id='container']/div/div[1]/div[1]/div[2]/div[1]/div/a[1]").click()
        time.sleep(8)
        try:
            driver.find_element(By.XPATH,
                                '//div[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div').click()
        except:
            time.sleep(10)
            print("Pop up showed")
            driver.find_element(By.XPATH, "/html/body/div[3]/div/span").click()
            driver.find_element(By.XPATH,
                                '//div[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div').click()
        time.sleep(4)

    @function_tracker
    def test_login(self, num):
        otp_button = driver.find_element(By.XPATH,
                                         "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[3]/button")
        assert otp_button.is_displayed()

        placeholder = driver.find_element(By.XPATH,
                                          "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/input")
        placeholder.click()
        placeholder.send_keys(num + Keys.RETURN)

        error_message = driver.find_element(By.XPATH,
                                            "//div[@id='container']/div/div[3]/div/div[2]/div/form/div[1]/span[3]/span")
        print("Error is: " + error_message.text)
        time.sleep(3)
        placeholder.clear()
        time.sleep(3)


a = Flipkart()

a.test_open_url("https://www.flipkart.com/")
a.test_search_item("samsung s24 ultra")
a.test_add_cart()
a.test_go_home()
numbers = ["12345678", "76543098", "123465"]
for n in numbers:
    print(f"Output data for {n}")
    a.test_login(n)
print("Completed All process")
