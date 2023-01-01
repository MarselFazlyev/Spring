## SpringMVC
SpringMVC - это один из компонентов Spring Framework (**паттерн проектирования приложений**),который позволяет разрабатывать web-приложения на Java\
SpringMVC предполагает разработку web-приложений с использованием архитектуры **Model-View-Controller**
Разрабатывая web-приложения с помощью SpringMVC,мы можем использовать все, что дает нам SpringCore - бины,DI, и так далее

**Model** - логика работы с данными\
**View** - логика представления, интерфейс\
**Controller** - логика навигации,обраотка запросов 

### Из чего состоит SpringMVC приложение?
- Из обычных Java классов (контроллеры, модели  и прочее).Очень активно используются аннотации,которые применяются к классам и дают им дополнительные возможности(например, аннотация @Controller)
- Набор HTML страниц (**представления**). К ним часто добавляется JavaScript код, который "оживляет" HTML представления  и CSS, который стилизует HTML.
-Spring конфигурация (XML,Аннотации,Java).

Также в SpringMVC есть компонент **DispatcherServlet**\
**DispatcherServlet** является входной точкой SpringMVC приложния. Он уже реализовани командой Spring, нам его реализовывать не надо.
 
 ### Алгоритм работы SpringMVC приложения
 HTTP запрос от пользователя:

 1) Приходит на сервер.Сервер обрабатывает запрос и передает его на Spring приложение. 
 2) Запрос попадает на DispatcherServlet.
 3) DispatcherServlet отправляет запрос на правильный контроллер.

### Контроллер 
- Обрабатывает запросы от пользователя 
- Обменивается даннными с моделью 
- Показывает пользователю правильное представление 
- Переадресовывает пользователя на другие страницы

### Модель 
- Хранит в себе данные 
- Взаимодействует с БД для получения данных 
- Отдает данные контроллеру

Для настройки проекта:
- сначала настраиваем сервер Tomcat: выбираем конфигурацию Tomcat->local->fix(выбираем артефакт, например, test:war exploded)->ok

- После настройки сервера рекомендуется перезапустить IntelligyIDEA из за возникающих непонятных  багов.\
Поле **application context** сделать пустым.\
- Добавим необходимые зависимости в pom.xml
- Реализуем **web.xml**,если конфигурируем с ним (web.xml считывается сервером Apache Tomcat,конфигурирует DispatcherServlet)\
  // современные приложения обычно не используют web.xml и applicationContext.xml, в основном используется аннотация **@Configuration**
- Реализуем **applicationContext.xml**
- Реализуем контроллер и представление (пока без модели) Необходимо пометить аннотацией **@Controller**

Для того, чтобы конфигурировать веб-приложение без ".xml"файлов, в проекте необходимо создать Java класс, который реализует интерфейс **org.springframework.web.WebApplicationInitializer**\
Такой класс считывается автоматически и работает как web.xml\
Можно использовать для конфигурации абстрактный класс **AbstractAnnotationConfigDispatcherServletInitializer**, он реализует интерфейс **org.springframework.web.WebApplicationInitializer** за нас


### Методы контроллеров
- Методов в контроллере может быть несколько 
- Обычно (но не всегда), каждый метод соответствует одному URL'у
- Обычно(но не всегда ), методы возвращают строку (String) - название представления, которое надо показать пользователю (могут вернуть, например json)
- У метода может быть любое название
### Маппинги
Всего 5 видов маппингов 
1) @GetMapping
2) @PostMapping
3) @PutMapping
4) @DeleteMapping
5) @PatchMapping

Иногда пишут устаревший вариант аннотации на методе  **@RequestMapping**(method=RequestMethod.GET)\
Но аннотация **@RequestMapping** на классе не является устаревшей и вполне используется для уточнения указания пути на контроллер

```
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
    //hellopage будет по адресу http://localhost:8080/first/hello
```

Маппинги связывают метод контроллера с адресом, по которому можно к этому методу обратиться (из браузера,например)\
Всего 5 видов маппинга - в зависимости от того, какой HTTP звпрос (с каким НТТР методом) должен прийти в этот метод контроллера 
чтобы ходить по разным страницам нашего приложения, можно использовать тег **<a></a>**\
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Goodbye</title>
</head>
<body>
Goodbye!

//на странице http://localhost:8080/goodbye появится ссылка "SayHello" на страницу http://localhost:8080/hello
<a href="/hello">SayHello</a>

</body>
</html>
```

### Пврвметры GET запроса в Spring Framework
Параметры GET запроса  можно получить двумя способами:

1) С помощью объекта **HTTPServletRequest**
```
 @GetMapping("/hello")
 public String helloPage(HTTPServletRequest request){
    String name = request.getParameter("name");
    // работаем с пришедшим от пользователя параметром

    return first/hello;
 }
```

2) С помощью аннотации **@RequestParam**
```
@GetMapping("/hello")
public String helloPage(@RequestParam("name") String name){
    // работаем с пришедшим от пользователя параметром
    return first/hello;
}

```
Если от GET запроса нам нужны только параметры, то второй способ получения параметров предпочтительнее, так как в первом методе мы полц-учаем большой объект запроса,в котором нам нужен только параметр.\
Первый способо нужен,если нам необходимо поработать полностью с запросом (например, нужны **header'ы**).
```
http://localhost:8080/hello?name=Milana&lastName=Milashkova // в параметры `name` и `lastName` контроллера придут 'Milana' и 'Milashkova'\
```
Еще одно различие : если параметры из метода Get передаются с помощью **HTTPServletRequest**, то при их отстутсвии в контроллер вернутся null.\
Если же параметры в контроллер передаются с помощью **@RequestParam**, то в случае их отстутствия в запросе Get вылетит ошибка.\
Для избежания ошибки можно прописать :
```

@GetMapping("/hello")
public String helloPage(@RequestParam(value="name", required =false) String name){
    // в случае, если параметр с ключом "name" не придет, в парметр метода 'helloPage()' положится null
    return first/hello;
}
```
в отображении hello.html,которое возвращает метод,также можно прописать параметры вместе с ссылкой **для передачи параметров при нажатии на ссылку**
```
<a href="/first/hello?name=Tanya&lastName=Tatianova">Tosya</a>
//в метод ,который маппится 
@RequestMapping("/first")
@GetMapping("/hello")
в качестве параметров передадутся 'Tanya''Tatianova'
```
### Получение доступа к модели в контроллере
**Модель**- контейнер для данных в приложении. 

Для получения доступа к модели в контроллере в параметрах метода достаточно прописать параметр "Model model",Spring сам внедрит необходимый объект в метод контроллера, с помощью "model.getAttribute" можем положить пару "ключ-значение", модель будет отправлена на представление, где с помощью шаблонизатора (thymeLeaf) мы сможем получить значение по ключу.
```
@GetMapping
public String helloPage(Model model){
    model.getAttribute("key","some Value")
    return "first/hello";

}
```
### CRUD (SpringMVCApp3)
**crud-операции**- четыре базовы функции, используемые при работе с БД
- create
- read
- update
- delete

чаще всего CRUD-приложжения являются web-приложениями. То есть, доступ к БД предоставляется через протокол HTTP.
 
 пример CRUD'a для сущности Post

 HTTP метод    URL              Действие

 GET           /posts           Получаем все записи(**READ**)
 POST          /posts           Создаем новую запись (**CREATE**)
 GET           /posts/new       HTML форма создания записи
 GET           /posts/:id/edit  HTML форма редактирования записи
 GET           /posts/:id       Получаем одну запись(**READ**)
 PATCH         /posts/:id       Обновляем запись (**UPDATE**) 
 DELETE        /posts/:id       Удаляем запись (**DELETE**)


 ### аннотация **@PathVariable** 
 аннотация **@PathVariable**- передает в метод параметр, который лежит в пути к контроллеру
 ```
 GetMapping("/{id}")
 public String show (@PathVariable ("id") int id, Model model) {
    // параметр из HTTP запроса "id " придет в int id
    return ...
 }

```
 ### аннотация @ModelAttribute
 данная аннотация может значительно упростить код\

 может аннотировать : 
 - метод
 ```
 @ModelAttribute("headerMessage")
 public String populateHeaderMessage(){
    return "Welcome to our website!!"
 }
 // в каждый метод контроллера мы добавляем пару "ключ-значение (headerMessage:"Welcome to our website!")
 используется, когда во всех методах контроллера нужно использовать данную пару.
 ```
 -Аргумент метода 
 ```
@PostMapping
public String post(@ModelAttribute ("person") Person person){
    return "successPage";
}
//аннотация создает объект Person (вместо Person person = new Person()), заполняет его поля значениями из  HTML формы (вместо сеттеров),автоматически добавляет в Model (вместо model.addAttribute()).
```
### Общий алгоритм **CREATE** реализации: 
1) создаем страницу с GET запросом для создания 
2) в возвращаемом из него шаблоне html прописываем необходимые параметры для заполнения полей объекта
3) из этого шаблона POST запросом (заполняется внутри html формы ) отправляется заполненный объект,сохраняется в БД в соответствующем @PostMapping методе контроллера.
4) осуществляется **редирект** (перенаправление) на нужную страницу.

### Особенности  Реализации PATCH,DELETE и других запросов  
Язык HTML реализует только GET И POST методы.Поэтому, когда мы реализуем форму в HTML, в качестве метода можно указать только метод GET или POST\
Для того, чтобы полностью реализовать потенциал методов протокола HTTP , проблема в HTML обходится следующим образом:
```
//PATCH ,DELETE,PUT запросы передаются с помощью POST запроса,но в скрытом поле _method указывается желаемый HTTP метод
 // по значению в скрытом поле _method Spring понимает и обрабатывает по факту PATCH метод

<form method="post" action="/people/1" 
 <input type="hidden" name = "_method" value="patch"> = $0
<label for="name"> Enter name:</label>
<input type="text" id="name" name="name" value="Tom">
<br>
<input type="submit" value="Update!">
</form>
```
Таким образом, с помощью  POST запроса можно передать любой запрос!

На стороне Spring приложения - с помощью фильтра\ 
Фильтр- объект, который перехватывает все входящие HTTP запросы. В данном случае фильтр используется для того, чтобы смотреть на значение поля **_method** в поступающих HTTP запросах(если это поле есть).
Чтобы на стороне Spring при передаче метод PATCH был распознан, необходимо создать фильтр, котороый будет искать значения этого скрытого поля.\
Делается это в конфигурационном файле Spring (в проекте SpringMVCApp3 есть пример - 2 метода **@Override onStartup()** и **registerHiddenFieldFilter()** )

### Валидация форм (проект SpringMVCApp4)
для того,чтобы в формы HTML можно было вносить только корректные значения, необходимо:
- скачать зависимость **hibernate-validator** в pom.xml
- установить аннотации (прописав в них правила валидации для соответствующего поля) непосредственно над полями, которые надо провалидировать
  например, **@NotEmpty**,**@Size**,**@Min**,**@Email**
```
public class Person{
    // валидация поля имени, чтобы это поле не было пустым
    @NotEmpty(message= "Name should not be empty!")
    // валидация длины поля 'name'
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 symbols")
    private String name;
    
    //аннотация минимального числового  значения 
    @Min(value = 0, message = "Age should be greater than 0!")
    private int age;
    
    @NotEmpty(message = "Email should not be empty!")
    //аннотация, которая следит, чтобы в поле лежал только email
    @Email(message = "Email should be valid")
    private String email;
}
```
- поставить перед получаемыми из формы объектами аннотацию **@Valid**, если условия нарушаются, то появляется ошибка, и эта ошибка помещается в отдельный объект **BindingResult**
```
@PostMapping()
public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
    personDAO.save(person);
    return "redirect:/people";
    //ВАЖНО!!! ОБЪЕКТ BindingResult нужно ставить сразу после модели, которая валидируется!!!!  
}
```
М.И. Примечание:\
При использовании аннотаций из пакета **jakarta** не выбрасывались соответствующие ошибки валидации полей,как ожидалось, сущность спокойно создавалась, причем некорректно, с некорректными параметрами. Данный косяк устранился только после отката зависимости **hibernate-validator** до версии 6.1.6.Final(c этой версии транзитивно загружается зависимость javax.validation) и навешивания аннотаций на поля сущности класса Person и  **@Valid** на валидирование сущности в контроллере из javax.validation.\ Что-то не так с пакетом jakarta...  

### JDBC API. БАЗЫ ДАННЫХ 
  Проблема : При перезапуске приложения теряем сохраненные данные.Необходимо хранить данные на жестком диске, ф нев оперативной памяти.\
  Для этого служат различные базы данных.Они хранят данные в виде набора таблиц.
  Виды связей Java приложения с Б/Д:
  - **JDBC API** -самый низкоуровневый способ (сами делаем все запросы к Б/Д и сами переводим Java объекты в строки таблицы и наоборот)
  - **JDBC Template** - тонкая обертка вокруг **JDBC API**.Часть Spring Framework.Предоставляет некоторые абстракции. Берет часть дел на себя.
  - **Hibernate**-самый высокий уровень абстракции.Практически не пишем вручную запросы к Б/Д. Автоматически переводит Java объекты в строки таблицы и наоборот.Может автоматически создавать таблицы в Б/Д на основании наших Java классов. Этот функционал называется ORM(Object Relational Mapping)

Как подключиться к Б/Д?
1) **запускаем Б/Д** У работающей Б/Д есть свой адрес (как и у сервера,localhost:8080/hello-world)
Адрес Б/Д:
- url=jdbc:postgresql://localhost:5432/db_name
- username=postgres
- password=
2) Используем JDBC драйвер,чтобы подключиться к БД с указанным адресом 
3) Можем делать запросы  к Б/Д из Java-приложения

**Базовые SQL-команды**
-**DDL** (Data Definition Language)
```
create DATABASE db_name;
drop database db_name;
create table table_name (
  id int,
  name varchar
);
drop table table_name;
```
- **DML** (Data manipulation language)
```
SELECT id,name FROM table_name;
SELECT * from table_name;
INSERT INT0 Person (id,name) VALUES (1,'Tom');
UPDATE Person SET name='Tom123' where id=1;
DELETE FROM Person where id = 1; 
```

**SpringMVCApp5 - код**
Для работы через "голый" JDBC нужно:
1) установить соединение с Б/Д
```
Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
```
2) Завести объект класса **Statement**(объект,который будет содержать в себе SQL запрос)
```
Statement statement = connection.createStatement();
```
3) Поместить в **statement** SQL запрос.
```
String SQL = "SELECT * FROM Person"
statement.executeQuerry(SQL);
```
4) Чтобы принять возвращаемые строки, нужен объект класса **ResultSet**
ResultSet resultSet = statement.executeQuerry(SQL);

5) вручную собрать объект из возвращаемых строк resultSet;
while(resultSet.next()){
    Person person = new Person();
    person.setId(resultSet.getInt("id"));
    person.setName(resultSet.getString("name"));
    person.setEmail(resultSet.getString("email"));
    person.setAge(resultSet.getInt("age"));

    people.add(person); //добавили человека в имитацию БД.
}


### SQL инъекции. Prepared statement. JDBC API 
Минусы обычного **statement**:
- Ручное составление SQL запроса каждый раз
- Неудобно 
- Легко допустить ошибку
- Угроза **SQL инъекции** (один из самых распространенных способов взлома сайтов  и программ, работающих с базами данных)
* Так как строки из HTML-формы  напрямую конкатенируются  в SQL запросе,злоумышленник  может подобрать такую строку, которая нанесет вред.
```
Примеры SQL инъекции

1)
String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() + "',"+ person.getAge()+ ",'" + person.getEmail() + "'")";
так как строки из HTML формы напрямую конкатенируются в SQL запросе,злоумышленник может подобрать такую строку, которая нанесет вред.
Если в качестве email в форме мы введем такую строку

test@mail.ru'); DROP TABLE Person; --

то получим такой SQL-запрос :
INSERT INTO Person VALUES(1,'test',15,'test@mail.ru'); DROP TABLE Person;--');

2) ЕсЛИ в поле userId ввести строку ниже,
UserId 150 OR 1=1 
то сработает такой SQL-запрос:
SELECT * FROM Users WHERE UserId = 105 OR 1=1;
условие 1=1 всегда будет true, поэтому вернется весь список users
```

### Prepared Statement

**Prepared statement** должен использоваться в JDBC API для всех запросов, где  содержатся  данные, полученные от пользователя.
Примеры в проекте SpringMVCApp5
Преимущества **Prepared statement**:
 - SQL запрос компилируется один раз и не может быть изменен.
 - Данные от пользователя могут быть вставлены лишь в указанные места и не могут изменить сам SQL-запрос.
 - Удобнее использовать, чем Statement (не надо вручную заниматься конкатенацией)
 - Быстрее,чем Statement.Особенно, если запросов много.

Если в качестве email'a в форме мы введем строку,
```
 test@mail.ru'); DROP TABLE Person; -- 
```
то эта строка будет просто помещена  в БД.Какие кавычки бы мы не использовали в email'е,он всегда будет восприниматься как строка.(Не сможем выйти за пределы строки)

### JDBC Template ( проект SpringMVCApp6JdbcTemplate)
Недостатки обычного JDBC API:
- много лишнего кода (создание Connection,создание Statement,работа с ResultSet),
- дублирование кода,
- Неинформативный SQLException,который надо везде обрабатывать.

Эти проблемы решаются с помощью JDBC template.
Для работы с JDBC template нужно скачать с центрального репозитория Maven зависимость **Spring jdbc**
1)Чтобы использовать JDBC template, нам необходимо его создать.
2)Для создания бина JDBC template нужен бин Data Source(нужен для JDBC template,чтобы он знал к какой БД подключаться).Импорт из пакета javax.sql 
3)Создать бин в конфигурационном файле (в нашем случае **Spring Config**),в конструкторе положить бин **Data Source** затем через **@Autowired** можно будет им пользоваться.

 В качестве второго аршумента нужно указать **RowMapper**-такой объект, который отображает строки из БД в сущности (объекты классов) Java.
```
  public List<Person> index() {
        return jdbcTemplate.query("select * from person ", new PersonMapper());
    }
```
**RowMapper** мы должны реализовать сами. Для этого создается класс, имплементирующий интерфейс **RowMapper** из пакета org.springframework...
Необходимо реализовать единственный метод **mapRow**, который также как и в обычном JDBC API, переведет строку из ResultSet, пришедшего по запросу  из БД,
в объект класса Java.

То есть,один раз описав перевод в сущность из ResultSet,мы избегаем дублирования кода.
В библиотеке jdbc.springframework... есть  готовый rowMapper,называется **BeanPropertyRowMapper**, в кострукторе надо указать тот класс, который будет переводиться из строк таблицы БД
```
  public List<Person> index() {
        return jdbcTemplate.query("select * from person ", new BeanPropertyRowMapper<>(Person.class));
    }
```



