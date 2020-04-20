# Translator

Translator is a translation app utilizing the Google Cloud Tranlation API. You can translate either by direct input, file input, or image input. Please select the language you want to translate to and we'll do the work!

## Iteration 1

***Usage for Iteration 1:***
1. Please clone project, and go to the eclipse marketplace and search "google cloud tools" and install it.
2. After installing, right click on the project folder->build path->add libraries.
3. click on google cloud libraries, hit next
4. check box cloud translation and hit finish
5. open and run Translator.java
6. Type 1 in command prompt (1 = Commandline input translate)
7. Give directed inputs (Caution: for now, we don't translate the inputs since our implementation is not complete yet). 
8. Thank you for using


Stories completed:

**1. Set up Google Cloud Development Account to utilize Google Cloud Translate API & Services**
  - Enabled Cloud Translation API and setting up Service Account to get private key as JSON 
  - Imported Google Cloud Client Libraries from Eclipse Marketplace
  - Set up environment variables
  - OCR setup using Tesseract4J library completed.
  
  **Note:** *Currently, the API is being called through a Google API key that is currently publicly accessible, which is something that needs to be fixed in future iterations. Ideally, the API should be configured to detect the private key JSON stored locally upon setup so the Google API key itself is not exposed. Following the guidelines at https://cloud.google.com/docs/authentication/production caused the program to not compile. We will investigate more into this.*
  
**2. Translating user input as a string through command prompt**
  - Wrote test case for example scenarios
  - Attempt call to Google Translate API

**3. Main method control flow**
  - InputTranslate logic is added
  - Set up some useful methods to check the validity of input and serialization. However, detailed implementations are not done yet. 

**4. Current Difficulties**
  - We are currently experiencing issues between the adding of Google Cloud Platform tools into the library from Eclipse's Google Cloud Platform App and git. Errors regarding GCP access is due to such errors. 
  - The Tesseract Library (Open Source) lacks precision and may not be powerful enough to use for our application. Currently looking into alternatives in the Google Cloud Platform's OCR API.

**TODO Next iteration:**
1. Generate auto detection of language input instead of manually selecting language being translated from. 
2. Reconfigure environment variables to keep API key more safe.
3. Complete main method to cover all translate cases. 
4. Improve quality and accuracy of OCR.



## Iteration 2

***Usage for Iteration 2:***
* Please note that We decided to extend our topic to create a travel application since a simple translator won't be suitable for this project. Users can now create an account, log in, and use the many wonderful services that we can provide. This will all be touched on in the last iteration, but for now, users can only still use the translator app.

* The travel app is a system where users can keep track of all the places they ever wanted to visit. They can add to a list of destinations they want to visit as well as add landmarks they want to visit for each destination. Each destination also includes a list of all the other users who want to visit this place as well. That way, a user can find a travel peer to go sightseeing with, or make some new friends! When traveling, our translator service will always be available to keep communication strong!

1. Please clone project in your Eclipse. 
2. In eclipse, please run the main method in Travel.java of userActivities package. 
3. Interact with the UI in the terminal.
4. Thank you for using!



Stories completed:

**1. Created sign up and log in interfaces =**
 - Created front page where users can create their accounts with preferred username and password.
 - Alphanumerics are checked and password is encrypted using BCrypt.

**2. Created user and location objects**
 - Users can now create an account for themselves and where they're from

**3. Created destination and landmark objects**
 - From the UI, users will soon be able to select their dream destination for travel and landmarks they want to visit there
 - From the UI, users will soon be able to see a list of other travel peers who also wish to visit the same destination
 
**3. Improved Main UI**
 - Users are now able to interact more smoothly with our app


**TODO Next iteration:**
1. Users will be able to add and modify their location information in their account.
2. Users will be able to add a dream destination and landmarks they want to visit.
3. Users will be able to see list of travel peers going to the same destination.
4. Users will be able to freely add/remove to their list of dream destinations as well landmarks for each destination.
5. Information will be persisted across sessions.
