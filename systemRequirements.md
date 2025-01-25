# Gym System Requirements



## **Functional Requirements**

- **User Registration and Roles:**  
   The system must support the registration of various user roles, including **Administrator**, **Receptionist**, **Personal Trainer**, and **Student**. Each role should have distinct permissions and access within the system.  
   - **Administrator**: Full access to manage users, exercises, and system settings.  
   - **Receptionist**: Responsible for registering **Personal Trainers** and **Students**.  
   - **Personal Trainer**: Can create and manage personalized workout plans for students.  
   - **Student**: Can access their personalized workout plans and track progress.

- **Exercise Management (Administrator):**  
   The system must allow the Administrator to create, edit, and manage exercises.  
   - Each exercise must include a name, description, type (e.g., free or machine-based), and the muscle groups it targets.  
   - Optional: Include an image, GIF, or video URL for exercise demonstration.

- **Personalized Workout Plans (Personal Trainer):**  
   The system must allow **Personal Trainers** to create customized workout plans for each student.  
   - A personalized workout plan consists of multiple exercises, with details such as the weight, sets, and repetitions for each exercise.  
   - The Personal Trainer should be able to adjust the workout plan based on the student’s progress or goals.



- **Functional Requirements**

- **Assessment Scheduling (Secretary and Personal Trainer):**  
   The system must allow the **Secretary** to schedule assessments between **Personal Trainers** and **Students**.  
   - The **Secretary** should be able to select the **Personal Trainer** and the **Student** for the assessment, as well as specify the date and time.  
   - During the assessment, the **Personal Trainer** will collect data about the **Student's physique**, such as body measurements, weight, and other relevant information.  
   - The system should allow the **Personal Trainer** to input and store this data for future reference.  
   - The **Personal Trainer** will also create and assign a **personalized workout plan** during the assessment, based on the student's current fitness level and goals.
