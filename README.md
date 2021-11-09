# BankRegistration
Android application UI screen for registering PAN and Date of Birth with Bank.

The below validations are done in this screen.

- Entered Birthdate must be a valid date.
- PAN number must be validated on client-side.
- If the birthdate / PAN number is not valid then the Next button must be disabled.
- On click of Next button show toast: "Details submitted successfully" and finish the activity.
- Dismiss activity on click of "I don't have a PAN"
- Architecture to be followed:
 - MVVM
 - Language: Kotlin, coroutines
