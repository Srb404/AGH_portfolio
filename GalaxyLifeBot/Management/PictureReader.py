import pyautogui
import pytesseract

pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract'


def read(x, y, x2, y2):
    myScreenshot = pyautogui.screenshot(region=(x, y, x2, y2))
    myScreenshot.save(r'.\temp\reader.png')

    image_text = pytesseract.image_to_string(r'.\temp\reader.png')
    return image_text


def readNumbers(x, y, x2, y2):
    image_text = read(x, y, x2, y2)
    value = ""
    for char in image_text:
        if char.isdigit():
            value = value + char
    return value
