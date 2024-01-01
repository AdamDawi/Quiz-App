# QuizFlag Mobile App

##  Description

QuizFlag is an interactive application that checked information about country flags. The application consists of a start screen, screens with questions and an end screen with user's score.

## Clone the repository to your local device

```bash
git clone https://github.com/AdamDawi/QuizFlag-Mobile-App
# Run the project in your IDE
```

## Add questions to project:
1. Open Constants.kt file
2. Add flag image to app/src/main/res/drawable
3. Write your custom question:
```kotlin
val questionName = Question(
            id, "What country does this flag belong to?",
            R.drawable.flagImage,
            "option1", "option2",
            "option3", "option4", numberOfCorrectAnswers
        )

        questionsList.add(questionName)
```

## Here are some pictures of the application:
![111](https://github.com/AdamDawi/QuizFlag-Mobile-App/assets/49430055/17db4737-f40a-4956-be18-315618c5e48f)
![222](https://github.com/AdamDawi/QuizFlag-Mobile-App/assets/49430055/2aecf406-6d17-4a50-958f-0ba5946c52b4)
![333](https://github.com/AdamDawi/QuizFlag-Mobile-App/assets/49430055/e3f5b382-7097-41e5-b2c6-111f90c0b0bf)
