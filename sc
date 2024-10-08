import requests
from bs4 import BeautifulSoup
import csv
import datetime

# Example URL (replace with actual URL of Schumann Resonance data)
url = "https://www.swpc.noaa.gov/products/goes-magnetometer"

# Send request to the webpage
response = requests.get(url)
soup = BeautifulSoup(response.content, "html.parser")

# Extract Schumann Resonance data (find the right tag and class, this is just an example)
# You'll need to inspect the webpage's HTML to find the correct way to extract the data.
resonance_data = soup.find("div", {"class": "resonance-value"}).get_text()

# Get current date/time for timestamping the data
current_time = datetime.datetime.now()

# Save data to CSV
with open('schumann_resonance_data.csv', mode='a', newline='') as file:
    writer = csv.writer(file)
    writer.writerow([current_time, resonance_data])

print(f"Saved Schumann Resonance data: {resonance_data} at {current_time}")
