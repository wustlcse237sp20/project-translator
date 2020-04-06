# Translator

Translator is a translation app utilizing the Google Cloud Tranlation API. You can translate either by direct input, file input, or image input. Please select the language you want to translate to and we'll do the work!

## Iteration 1

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
  - The Tesseract Library (Open Source) lacks precision and may not be powerful enough to use for our application. Currently looking into alternatives in the Google Cloud Platform's OCR API.

**TODO Next iteration:**
1. Generate auto detection of language input instead of manually selecting language being translated from. 
2. Reconfigure environment variables to keep API key more safe.
3. Complete main method to cover all translate cases. 
4. Improve quality and accuracy of OCR.

**Usage for Iteration 1:**
1. Please clone project, and go to the eclipse marketplace and search "google cloud tools" and install it.
2. After installing, right click on the project folder->build path->add libraries.
3. click on google cloud libraries, hit next
4. check box cloud translation and hit finish
5. open and run Translator.java
6. Type 1 in command prompt (1 = Commandline input translate)
7. Give directed inputs (Caution: for now, we don't translate the inputs since our implementation is not complete yet). 
8. Thank you for using
