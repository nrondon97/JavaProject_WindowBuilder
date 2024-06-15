# SignIn GUI Application

## Overview

This Java application, developed by Naylene Rondon for the Florida Tech CIS 2503 course (8.5 Programming Assignment), is a GUI-based sign-in system. It allows users to enter usernames and passwords, and provides functionalities for both signing in and signing up.

## Features

- GUI interface using SWT (Standard Widget Toolkit) for Java.
- Supports both signing in with existing credentials and signing up with new usernames and passwords.
- Provides error messages for missing information, incorrect passwords, and successful logins.
- Includes a checkbox option to show or hide passwords entered in the password field.

## How It Works

1. **Initialization**:
   - Initializes the SWT display, creates the main shell (`shell`), and sets up various UI components such as labels, text fields, buttons, and error message displays.

2. **Sign In and Sign Up**:
   - **Sign In**:
     - Validates user input for both username and password fields.
     - Checks entered credentials against stored usernames and passwords.
     - Displays appropriate error messages for missing information, incorrect passwords, or successful logins.
   - **Sign Up**:
     - Allows users to register new usernames and passwords.
     - Stores entered usernames and passwords in ArrayLists (`username` and `password`).
     - Toggles between sign-in and sign-up modes using the "Sign Up" button.

3. **Password Visibility**:
   - Includes a "See Password?" checkbox (`btnSeePassword`) that allows users to show or hide the characters entered in the password field (`passwordField`).
