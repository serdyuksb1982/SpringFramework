Spring Framework, по шагам, согласно курса Udemy.

	Продолжение изучения Spring:
   Spring Boot.  Spring Initializr. В основе проект SpringBoot (далее - проект), что был в 6-ом модуле.
В Spring Boot дефолтной реализацией JPA является Hibernate. Добаление Devtools, для автоматизации обновления изменений в проекте.
Использование функционала JPA, вместо Hibernate - JAVAX.persistence.QUERY. Это позволяет использовать один раз написанный
код для других реализаций JPA API, на случай, если придется менять Hibernate. Все изменения проекта происходят в Repository, те
EmployeeDAOImpl классе. Уже мы не используем Session, сразу создаем Query (query не работает с Generics), пишем запрос, выполняем его.
Методы find, merge...
