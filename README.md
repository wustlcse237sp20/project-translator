# cse237-project

## Iteration 1

Stories completed:
1. Set up Google Cloud Development Account to utilize Google Cloud Translate API & Services
  - Enabled Cloud Translation API and setting up Service Account to get private key as JSON 
  - Imported Google Cloud Client Libraries from Eclipse Marketplace
  - Set up environment variables
  
  **Note:** *currently, the API is being called through a Google API key that is currently publicly accessible, which is something that needs to be fixed in future iterations. Ideally, the API should be configured to detect the private key JSON stored locally upon setup so the Google API key itself is not exposed. Following the guidelines at https://cloud.google.com/docs/authentication/production caused the program to not compile. We will investigate more into this.*
  
2. Translating user input as a string through command prompt
  - Wrote test case for one scenario
  - Attempt call to Google Translate API
  
TODO Next iteration:
1. Generate auto detection of language input instead of manually selecting language being translated from. 
2. Reconfigure environment variables to keep API key more safe.
