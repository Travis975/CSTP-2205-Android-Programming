// =================================== Lab 1 Grade Calculator ===================================
// Write a program that is a grade calculator.
// User can print a report of the students grades at any time.
// The user have no restriction on the number of assessments they can add as Exams, Labs or Project they can enter.
// Printing the report will show all the assessments for the course by each category,
// The user will also see a FINAL GRADE of the course achievement
// User can enter the commands:
// e - enter grade, pr - print report, q - quit
// Next layer: select category -> lbs - labs, pr - projects, ex - exams, r - return to main menu
// User inputs: assessment name, earned marks, total marks
// Then total mark for the student is made from the combination of each category

// Category weights:
// labs - 30%
// projects - 40%
// exams - 30%

// What to avoid:
// 1. You may not use an array to store the values
// 2. Your solution must not use any user defined functions other than main().
// ==============================================================================================

import kotlin.math.roundToInt

fun main() {
    println("Lab 1 Grade Calculator")

    // Declare variables needed
    // The constants
    val LABS_WEIGHT: Double = 0.3
    val PROJECTS_WEIGHT: Double = 0.4
    val EXAMS_WEIGHT: Double = 0.3

    var totalLabsMarksReceived: Double = 0.0
    var totalPossibleLabsMarks: Double = 0.0
    var totalProjectsMarksReceived: Double = 0.0
    var totalPossibleProjectsMarks: Double = 0.0
    var totalExamsMarksReceived: Double = 0.0
    var totalPossibleExamsMarks: Double = 0.0

    var labReport: String = ""
    var projectReport: String = ""
    var examReport: String = ""


    while (true) {
        println("\nCommands: e - enter grade, pr - print report, q - quit")
        when (readln().trim().lowercase()) {
            "e" -> {
                println("Select category: lbs - Labs, pr - Projects, ex - Exams, r - Return to main menu")
                when (readln().trim().lowercase()) {
                    "lbs" -> {
                        println("Enter assessment name:")
                        val name : String = readln().trim()

                        // Used toDoubleOrNull() to avoid crashing when a user entered in NaN value for marks.
                        println("Enter earned marks:")
                        val earnedMarks : Double? = readln().toDoubleOrNull()

                        println("Enter total marks:")
                        val totalMarks : Double? = readln().toDoubleOrNull()

                        if (earnedMarks != null && totalMarks != null && earnedMarks <= totalMarks) {
                            totalLabsMarksReceived += earnedMarks
                            totalPossibleLabsMarks += totalMarks
                            labReport += "$name $earnedMarks/$totalMarks\n"
                            println("Added: $name ($earnedMarks/$totalMarks)")
                        } else {
                            println("Invalid marks entered. Please enter the assessment again.")
                        }
                    }

                    "pr" -> {
                        println("Enter assessment name:")
                        val name : String = readln().trim()

                        println("Enter earned marks:")
                        val earnedMarks : Double? = readln().toDoubleOrNull()

                        println("Enter total marks:")
                        val totalMarks : Double? = readln().toDoubleOrNull()

                        if (earnedMarks != null && totalMarks != null && earnedMarks <= totalMarks) {
                            totalProjectsMarksReceived += earnedMarks
                            totalPossibleProjectsMarks += totalMarks
                            projectReport += "$name $earnedMarks/$totalMarks\n"
                            println("Added: $name ($earnedMarks/$totalMarks)")
                        } else {
                            println("Invalid marks entered. Please enter the assessment again.")
                        }
                    }

                    "ex" -> {
                        println("Enter assessment name:")
                        val name : String = readln().trim()

                        println("Enter earned marks:")
                        val earnedMarks : Double? = readln().toDoubleOrNull()

                        println("Enter total marks:")
                        val totalMarks : Double? = readln().toDoubleOrNull()

                        if (earnedMarks != null && totalMarks != null && earnedMarks <= totalMarks) {
                            totalExamsMarksReceived += earnedMarks
                            totalPossibleExamsMarks += totalMarks
                            examReport += "$name $earnedMarks/$totalMarks\n"
                            println("Added: $name ($earnedMarks/$totalMarks)")
                        } else {
                            println("Invalid marks entered. Please enter the assessment again.")
                        }
                    }

                    "r" -> {
                        println("Returning to main menu...")
                    }

                    else -> {
                        println("Invalid category. Returning to main menu.")
                    }
                }
            }

            "pr" -> {
                println("\n--- Grade Report ---")

                println("Lab Marks:\n")
                if (labReport.isNotEmpty()) println(labReport) else println("No labs entered.")

                println("\nProject Marks:\n")
                if (projectReport.isNotEmpty()) println(projectReport) else println("No projects entered.")

                println("\nExam Marks:\n")
                if (examReport.isNotEmpty()) println(examReport) else println("No exams entered.")

                val labPercentage =
                    if (totalPossibleLabsMarks > 0) ((totalLabsMarksReceived / totalPossibleLabsMarks) * 100) * LABS_WEIGHT else 0.0
                println("\nLab Total: ${totalLabsMarksReceived}/${totalPossibleLabsMarks} Percentage: ${"%.2f".format(labPercentage)}%")

                val projectPercentage =
                    if (totalPossibleProjectsMarks > 0) ((totalProjectsMarksReceived / totalPossibleProjectsMarks) * 100) * PROJECTS_WEIGHT else 0.0
                println("Project Total: ${totalProjectsMarksReceived}/${totalPossibleProjectsMarks} Percentage: ${"%.2f".format(projectPercentage)}%")

                val examPercentage =
                    if (totalPossibleExamsMarks > 0) ((totalExamsMarksReceived / totalPossibleExamsMarks) * 100) * EXAMS_WEIGHT else 0.0
                println("Exam Total: ${totalExamsMarksReceived}/${totalPossibleExamsMarks} Percentage: ${"%.2f".format(examPercentage)}%")

                val coursePercentage = (labPercentage + projectPercentage + examPercentage)

                // First calculate the students total percentage then round to nearest whole number for the grade
                val coursePercentageRounded = coursePercentage.roundToInt()

                println("\nCurrent Course Percentage: ${coursePercentageRounded}%")
                println(
                    "Current Letter Grade: ${
                        when {
                            // Was written as coursePercentage >= 81.0 && coursePercentage <= 85.0 -> "B+" 
                            // Then convert to range check ex. in (#>=..<=#) to simplify comparison. IDE suggested. 
                            coursePercentageRounded >= 96.0 -> "A+"
                            coursePercentageRounded in 91..95 -> "A"
                            coursePercentageRounded in 86..90 -> "A-"
                            coursePercentageRounded in 81..85 -> "B+"
                            coursePercentageRounded in 76..80 -> "B"
                            coursePercentageRounded in 71..75 -> "B-"
                            coursePercentageRounded in 66..70 -> "C+"
                            coursePercentageRounded in 61..65 -> "C"
                            coursePercentageRounded in 56..60 -> "C-"
                            coursePercentageRounded in 50..55 -> "D"
                            else -> "F"
                        }
                    }"
                )
            }

            "q" -> {
                println("Exiting. Goodbye!")
                break
            }

            else -> {
                println("Invalid command. Try again.")
            }
        }
    }
}

