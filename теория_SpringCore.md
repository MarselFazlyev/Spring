## Spring
### Bean 
**Bean**- это просто Java- объект.Когда Java объекты создаются с помощью Spring'a ,они называются бинами (beans)\
Бины создаются из Java классов (так же, как и обычные объекты)\
```
 <bean id="testBean" class="org.example.model.TestBean">
        <constructor-arg value="Marsel"/>
    </bean>
```

### Типичные шаги в работе со Spring :
 - Создаем Java - классы (будущие бины)
 - Создаем и связываем  бины  с помощью Spring (аннотации,XML или Java код)
 - При использовании, все объекты (бины) берутся из контейнера Spring.

### Способы внедрения зависимостей:
 - Через конструктор 
 - Через сеттер 

 Есть множество конфигураций,как внедрять зависимости (**scope**,**factory method** и  тд)\
 Можно внедрять через XML, аннотации или Java-код\
 Процесс внедрения можно автоматизировать (Autowiring)

когда мы хотим сослаться на значения  во внешнем файле (например, application.property),можно прописать конструкццию:
```
<context:property-placeholder location="classpath:musicPlayer.properties"
```
таким образом, Spring найдет эти значения

Для внедрения зависимости через "сеттер" необходимо иметь в классе пустой конструктор.

**Scope** задаёт то, как Spring  будет создавать бины.
Если мы явно не указываем scope, то по умолчанию будет использоваться скоуп "Singleton"\
- По уиолчанию создается один объект (он создается до вызова метода getBean()).
- При всех вызовах getBean() возвращается ссылка на один и тот же единственный объект.
Проблема в том, что если  этот объект изменить (например, громкость в MusicPlayer), то это изменение произойдет на всех объектах, использующих данную зависимость.
```
MusicPlayer firstMusicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
MusicPlayer secondMusicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
boolean comparsion = firstMusicPlayer == secondMusicPlayer;
  System.out.println(comparsion); //true 
```
Этот скоуп чаще всего используется тогда, когда у нашего Бина нет изменяемых состояний (stateless).

**Prototype** - скоуп, который каждый раз создает новый объект при вызове getBean()
```
MusicPlayer firstMusicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
MusicPlayer secondMusicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
boolean comparsion = firstMusicPlayer == secondMusicPlayer;
  System.out.println(comparsion); //false
```
Этот скоуп чаще всего используется тогда, когда у нашего Бина есть изменяемые состояния (stateful).\
Также есть скоупы :\
**request**,**session**,**global-session** 
### Жизненный цикл бина

 

