# 5daysWeather

The project is completed around 4 hours. The method is similar to MVVM but not exactly MVVM. View binding is used in the project and retrofit is used for API integration. APIClient will store the details of base url and API interface will be calling the details of the API. User can search their city but enter the city name in Edittext field and hit the search button to search it. Details of 5 days weather every 3 hours will be shown in the recyclerview. For future improvement, I will consider to allow user to search in spinner for their country and city. Besides, more categories should be included based on user selection. Besides, if there is more time, I will add Internet connection checker to avoid user close the internet and API goes wrong.

# Test Cases
- search valid city name - show progress dialog - data loaded
- search invalid city name - progress dialog dismiss - system shows message Invalid City
- hit search button - keyboard dismiss
