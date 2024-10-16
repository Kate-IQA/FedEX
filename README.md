# Manual Test Suite: Hand-run validation

## TC01 - Validation for empty fields in the registration form
- **Objective**: Ensure that the registration form shows appropriate validation errors when mandatory fields are left empty.
- **Steps**:
  1. Open the registration page.
  2. Leave all mandatory fields blank.
  3. Click the Submit button.
- **Expected Result**: The form should display validation errors indicating that required fields are missing, and the form should not be submitted.

## TC02 - Password strength validation
- **Objective**: Ensure the password field meets strength requirements (if applicable).
- **Steps**:
  1. Enter a weak password (e.g., "12345").
  2. Attempt to submit the form.
- **Expected Result**: The form should display an error message indicating that the password does not meet the required strength.

## TC03 - Profile update functionality
- **Objective**: Verify that a user can update their profile information successfully.
- **Steps**:
  1. Log in with valid credentials.
  2. Navigate to the profile update page.
  3. Modify certain fields (e.g., first name, last name).
  4. Click Save or Submit.
- **Expected Result**: The user profile should be updated, and a confirmation message should appear.

## TC08 - Check “I agree” checkbox functionality
- **Objective**: Ensure that the "I agree" checkbox works as intended and is a required field before form submission.
- **Steps**:
  1. Fill out all mandatory fields in the form, but do not check the "I agree" checkbox.
  2. Click Submit.
- **Expected Result**: The form should display a validation error indicating that the checkbox must be selected.

## TC09 - SQL Injection Validation
- **Objective**: Test that the form is protected against SQL injection.
- **Steps**:
  1. Enter a SQL injection attempt in the text fields (e.g., "OR 1=1").
  2. Click Submit.
- **Expected Result**: The form should not be submitted, and an error message should appear, preventing malicious SQL code from being executed.

---

# Automated Test Suite: Automated Registration Form Validation

## TC05 - Verify email format validation
- **Objective**: Ensure that the email format is validated correctly.
- **Automation**:
  1. Open the registration form.
  2. Enter an invalid email format (e.g., "invalid-email").
  3. Submit the form.
  4. Verify that the error message "Invalid email format" is displayed.

## TC06 - Confirm email match
- **Objective**: Ensure that the confirmation email matches the original email field.
- **Automation**:
  1. Fill out the email field with "test@example.com".
  2. In the confirm email field, enter a different value like "test2@example.com".
  3. Submit the form.
  4. Verify that the error message "Emails do not match" is displayed.

## TC07 - Valid form submission
- **Objective**: Ensure that the form can be submitted successfully when valid data is entered.
- **Automation**:
  1. Navigate to the registration form.
  2. Fill out all required fields with valid data.
  3. Agree to the terms by selecting the checkbox.
  4. Submit the form.
  5. Verify that a success message is displayed, indicating the form was submitted.
