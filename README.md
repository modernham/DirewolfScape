[![License: CC BY-NC-SA 4.0](https://img.shields.io/badge/License-CC%20BY--NC--SA%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc-sa/4.0/)

<br />
<p align="center">
  <h3 align="center">Direwolf Scape An open source MMORPG emulation server</h3>



## First, a Thanks
Thank you to all the people who have contributed to 2009scape so far!
<a href="https://github.com/2009scape/2009scape/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=2009scape/2009scape" />
</a>


## Getting Started

### Github Setup

<h4>Note: This allows you to commit changes to the main repo (with approval)! Also, always stay up to date with the most recent updates by pulling into your copy when 2009Scape updates!</h4>

1. Create a github account if you haven't done so already

2. Go to the 2009Scape <a href="https://github.com/2009scape/2009Scape">Github Page</a>

3. Click "Fork" in the top right hand side of Github

**If at anytime you have an issue with Github please refer to the** <a href="https://docs.github.com/en/free-pro-team@latest/github">Github help center.</a>


### Prerequisites

<h4>Note: It is required for a developer submitting a PR to use Intellij IDEA as your integrated development environment.</h4>

* Intellij IDEA
* Java SE Development Kit Version 1.8
* Gradle (optional - Installs with Intellij on project build)
* Xampp

## Prereq Installation

<h3>Windows</h3>
<details>
<summary> </summary>

1. Install <a href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">JDK version 1.8</a>
    * Scroll down until you see Windows x86 and Windows x64
    * If you are running a 64bit verison of Windows (standard), select Windows x64
    * Accept the terms and conditions, after reading them of course, and login to oracle
    * Download and install like any normal application
    
2. Install <a href="https://www.jetbrains.com/idea/">Intellij IDEA</a>
    * Click "Download" on the main page
    * Ensure "Windows" is selected at the top
    * Select "Community download"
    * Download and install like any normal application
    
3. Install <a href="https://gradle.org/">Gradle</a>
    * Click on "Install Gradle" 
    * Scroll down to "Installing manually" 
    * Download "Binary-only"
    * Scroll down until you see "Microsoft Windows users"
    * Follow the instructions listed on the website
    
4. Install <a href="https://www.apachefriends.org/index.html">Xampp</a>
    * Click on "Xampp for Windows"
    * Download
    * Install as Administrator
</details>  
    
<h3>MacOS</h3>
<details>
<summary> </summary>

1. Install <a href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">JDK version 1.8</a>
    * Scroll down until you see macOS x64
    * select macOS x64
    * Accept the terms and conditions, after reading them of course, and login to oracle
    * Download and install like any normal mac application

2. Install <a href="https://www.jetbrains.com/idea/">Intellij IDEA</a>
    * Click "Download" on the main page
    * Select "Mac" towards the top of the main page
    * Select "Community download"
    * Download and install like any normal application
    
3. Install <a href="https://gradle.org/">Gradle</a>
    * Click on "Install Gradle" 
    * Scroll down to "Installing manually" 
    * Download "Binary-only"
    * Scroll down until you see "Linux & MacOS users"
    * Follow the instructions listed on the website
    
4. Install <a href="https://www.apachefriends.org/index.html">Xampp</a>
    * Click on "Xampp for OS X"
    * Download
    * Install as Administrator
</details>

<h3>Linux</h3>
<details>
<summary> </summary>

1. Install JDK version 1.8 through <a href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">Oracle</a> or through <a href="https://openjdk.java.net/install/">command line</a>
    * Debian, Ubuntu, etc.
    ```sh
    sudo apt-get install jre8-openjdk
    ```
    * Fedora, Oracle Linux, Red Hat Enterprise Linux, etc.
    ```sh
    su -c "yum install java-1.8.0-openjdk"
    ```  
  
2. Install Intellij IDEA through <a href="https://www.jetbrains.com/idea/">Intellij Website</a> or through <a href="https://www.jetbrains.com/help/idea/installation-guide.html#snap">Command Line</a>
    * Debian, Ubuntu, etc.
    ```sh
    sudo snap install intellij-idea-community --classic
    ```

3. Install Gradle through the <a href="https://gradle.org/">Gradle Website</a> or through <a href="https://gradle.org/">Command Line</a>
    * Click install Gradle
    * If you're installing through Command Line follow : Installing with a package manager
    * If you're installing through Download follow : Installing manually : Linux & MacOS users
    ```sh
    sdk install gradle 6.6.1
    ```
    
4. Install <a href="https://www.apachefriends.org/index.html">Xampp</a>
    * Click install "XAMPP for Linux"
    * Install like any normal Linux program
</details>


### Project Setup

1. Open Xampp
    * On Windows make sure you run Xampp as administrator
    * On the left hand side make sure you tick the two "Service" boxes for Apache and MySQL
    * For both Apache and MySQL click "Start" under Actions
    * After doing that navigate to the <a href="https://localhost/phpmyadmin/">PHP My Admin LOCAL SITE</a>
    * Once opened, on the left hand side click the three "disks" that say "New"
    * In the "Database name" bar type: global
    * Press the "Create" button
    * A three disk "global" should appear on the left hand side
    * Click it and on the top bar select "Import"
    * Under **FILE TO IMPORT** click "Browse...." 
    * Navigate to your 2009Scape project folder
    * Go to Server/db_exports/ and import global.sql
    * It may take a moment to import, when It is done importing Xampp is all set up!

2. Open Intellij
    * Select Get from Version Control
    * Click on "Github", and you will be asked to login
    * Change your directory to wherever you want the project to load, or keep it default
    * On the right hand side you should see your Github Repository for 2009Scape
    * Select it and hit "Clone"
    * The project should instantly start building on import. Give it some time because it is going through and compiling alot of files
    * In Intellij go to File -> Project Structure -> Project and verify your Project SDK is set to JDK "1.8"
    * Setup through Intellij should now be finished!
    
### Running the project

1. Navigate to the right hand side of Intellij where it says "Gradle"
    * Gradle is very useful when it comes to running and compiling the project
    * The only tabs we are concerned about are "Client", "Management-Server", and "Server"
    * Each of these have a "Tasks" folder and an "application" folder
    <br>
2. Click on the "application" folder for the Management-Server and double-click "run"
    * The management server is used for things such as player data(not saves), highscores, and world information
    <br>
3. Click on the "application" folder for the Server and double-click "run"
    * Please note this may take a minute or two to build, it is compiling a lot of files!
    * If you receive an error on server start, check and make sure that your worldprops/default.json is pointing to the correct paths
    <br>
4. Copy your cache from 2009Scape/Server/data/cache (.dat2/.idx0-255) to C:/Users/(your_name)/.runite_rs/runescape/
    * As of the writing of this readme, cache downloading is still broken. It is on the agenda to be fixed in the future
    * **If you don't have those folders then create them**
    * Server debug mode/other information can be changed in worldprops/default.json
    <br>
5. Click on the "application" folder for the Client and double-click "run"
    * If you receive an error on client run open your build.gradle to verify that the mainClassName is set to the correct location
    * Due to client work that is on going a lot of files get changed and new paths for the main class are created
    * **FIX** In your build.gradle change the mainClassName and Main-Class attributes to 'org.runite.jagex.Client'
    * If Gradle run still does not work, launch the Client by navigating to Client/src/main/java/org.runite/jagex/Client
    * Right click on the client and select Run 'Client.main()'
    * Client debugging options can be found inside of config.json

### License

We use the CC BY-NC-SA 4.0 license, which can be found <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/">here.</a> Please read and understand the license. Failure to follow the guidelines outlined in the license will result in legal action. If you know or hear of anyone breaking this license, please send a report, with proof, to Red Bracket#8151, ceikry#2724, or woahscam#8535 on discord or email woahscam@hotmail.com. **We WILL NOT change the license to fit your needs.**

### Contact


[license-shield]: https://img.shields.io/badge/License-CC%20BY--NC--SA%204.0-lightgrey.svg
[license-url]: https://creativecommons.org/licenses/by-nc-sa/4.0/
