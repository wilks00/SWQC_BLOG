# SWQC_BLOG
-------------------------------------
phpMyAdmin SQL Dump v4.8.3
DATA BASE : bd_blog
---------------------------------------------------------------------------------------------------------------
<<<<<TABLA BLOG>>>>>
CREATE TABLE `blog` (
  `id` int(10) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `titulo` varchar(600) NOT NULL,
  `contenido` varchar(6000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);
 
--->>>>>>datos en la tabla 'blog'<<<<<<<---
INSERT INTO `blog` (`id`, `fecha`, `titulo`, `contenido`) VALUES
(1, '2000-02-02 02:00:00', 'BERSERK  ベルセルク  ', 'es un manga creado por Kentaro Miura y posteriormente adaptado en anime, con un estilo épico fantástico y de fantasía oscura. Miura publicó un prototipo de Berserk en 1988. El manga comenzó a publicarse al año siguiente en la extinta revista mensual Animal House, hasta que fue reemplazada en 1992 por la revista quincenal Young Animal, donde Berserk continúa siendo publicado a un ritmo irregular '),
(2, '2001-01-01 01:00:00', 'HELLSING  ヘルシング ', 'es una serie de manga escrita e ilustrada por Kōta Hirano que posteriormente tuvo su versión anime producida por Gonzo. Su primera edición fue en Young King OURs en 1997 y finalizó en 2008. Los capítulos individuales han sido publicados en diez volúmenes tankōbon por Shōnen Gahōsha en septiembre de 2008. El manga relata los esfuerzos de los misteriosos y secretos Caballeros Protestantes Reales, «Hellsing» y sus combates contra vampiros, ghouls y otros enemigos sobrenaturales que amenazan al reino de Gran Bretaña');

--------------------------------------------------------------------------------------------------------------------
<<<<<TABLA LOGIN>>>>>

CREATE TABLE `login` (
  `id` int(11) UNSIGNED NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--->>>>>>datos en la tabla 'login'<<<<<<<---
INSERT INTO `login` (`id`, `usuario`, `pass`) VALUES
(1, 'wilmer', '666999'),
(2, 'admin', 'admin');

--------------------------------------------------------------------------------------------------------------------


>>>>autoincremento<<<<

 MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
 
 MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  


