[![Product Name Screen Shot][product-screenshot]](https://example.com)
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#concept-of-stay-finder">Concept</a></li>
        <li><a href="#purpose-of-stay-finder">Purpose</a>
          <ul>
            <li><a href="#real-time-price-comparison">Real-time Price Comparison</a></li>
            <li><a href="#user-friendly-interface">User-friendly Interface</a></li>
            <li><a href="#advanced-search-functionality">Advanced Search Functionality</a></li>
            <li><a href="#secure-and-reliable">Secure and Reliable</a></li>
          </ul>
        </li>
        <li><a href="#why-stay-finder-is-essential">Why Stay Finder Is Essential</a></li>
      </ul>
    </li>
    <li><a href="#built-with">Built With</a></li>
    <li><a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#running-the-application">Running the Application</a></li>
        <li><a href="#installing">Installation</a></li>
        <li><a href="#testing">Testing</a></li>
      </ul>
    </li>
    <li><a href="#swagger-documentation">Swagger Documentation</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>


# Stay Finder - Hotel Booking Aggregator

Stay Finder is a web application designed to provide a comprehensive and user-friendly platform for comparing hotel prices, amenities, and availability. Our application caters primarily to travelers seeking convenient and cost-effective accommodation options.

# Concept of Stay Finder

Stay Finder aggregates data from multiple third-party booking websites, allowing users to find the best prices and options for hotels, apartments, and rooms. It simplifies the search for accommodations by providing detailed descriptions, high-quality images, and real-time price comparisons.

# Purpose of the Stay Finder Application

## Real-time Price Comparison

The application fetches and compares prices from various trusted websites to ensure users can find the best deals.

## User-friendly Interface

Features a sophisticated yet engaging interface that facilitates easy navigation and interaction, enhancing the overall user experience.

## Advanced Search Functionality

Users can search for hotels based on various criteria such as location, date, price range, and amenities.

## Secure and Reliable

Implements modern security protocols to ensure user data protection and transaction security.

# Why Stay Finder Is Essential

- **Cost-Effective Travel Planning**: Helps users plan their travels by providing a platform to compare various accommodation options based on price and other preferences.
- **Convenience**: Reduces the hassle of visiting multiple sites to book accommodations.
- **Informed Decisions**: Offers detailed descriptions and user reviews, helping travelers make well-informed accommodation choices.

### Built With

- [![Next][Next.js]][Next-url]
- [![React][React.js]][React-url]
- [![Vue][Vue.js]][Vue-url]

# Running the application

To run the Stay Finder application locally, follow these steps:

1. **Frontend Setup**:

   ```bash
   cd frontend
   npm install
   npm build
   npm start
   ```

    ```
   REACT_APP_BACKENDURL=http://localhost:8080
   REACT_APP_IMGURL=http://localhost:8080
   ```

   make sure to implement the .env file in the frontend

2. **Run our datasbase**:
  in our solution we used xamp to host our database on port 3306, it can be adjusted i the application properties

3. **Backend Setup**:
   ```bash
   Open backend folder
   Run MainApplication.java
   ```
   Our database is hosted seperate from our backend, if the database is not running it may cause some issues for the backend

   Here is a youtube guide for launching our application:
   https://youtu.be/WsxglAxVtCY

# Installing

To build the project and create a deployable artifact, run:

    ./mvnw clean install

# Testing

To execute unit tests for both frontend and backend, use the following commands:

- **Frontend Tests**:

  ```bash
  cd frontend
  npm test
  ```

- **Backend Tests**:
  ```bash
  cd backend
  ./mvnw test
  ```



# Swagger Documentation

Access our API documentation via [Swagger UI](http://localhost:8080/swagger-ui/index.html#/).


## Code Contributors

This project exists thanks to the contributions from our development team.

👤 Jan Christian Nordskog
👤 Avnit
👤 Ulrik
👤 Alejandro

---

## Authors

👤 Jan Christian Nordskog

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: https://i.imgur.com/Xe6Vd8r.png
[Next.js]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Next-url]: https://spring.io/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white
[Vue-url]: https://www.mysql.com/

