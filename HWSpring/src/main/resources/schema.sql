create table students (
      id int primary key auto_increment,
      first_name varchar(255) not null,
      last_name varchar(255) not null,
      age int not null,
      "group" varchar(255) not null
);

create table groups(
      id int primary key auto_increment,
      group_name varchar(255) unique not null
);