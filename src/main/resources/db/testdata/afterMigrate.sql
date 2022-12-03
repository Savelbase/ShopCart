delete from users where id is not null;
delete from goods where id is not null;
delete from orders where id is not null;

-- Password :
--     admin : Qwerty1!
--     client : Qwerty2!

insert into users (id, first_name, last_name, email, password, login, phone_number , role)
values ('184ed5b6-102c-432c-b7ba-129806a448e8', 'Ivan', 'ivan@mail.com' ,'Ivanov@gmail.com', '$2a$04$qs9fqITKr.T3AuFJ3jfHI.USC9x5L9uJO9JZrjio3iF6d/yzKoqs6', 'IvanIvan1', '0660669213' , 'CLIENT'),
       ('184ed2b6-102c-412c-b7ba-123803w248e8', 'Kostya', 'Savin' ,'manager@gmail.com', '$2a$04$V0kZc2EndC0fEN2ud6Mekuj4KkPlbSaTBh65tWBuOPCeFExQu/PpC', 'admin', '0990997828' , 'MANAGER');

insert into goods (id, name, description, costs) VALUES
('6cd2cd0b-b206-4d3e-9a2a-ee24e687d3e7' ,  'Iphone 11 ' , ' is a smartphone designed, developed, ' ||
                        'and marketed by Apple Inc. It is the 13th generation of iPhone, succeeding the iPhone XR, and '||
                        'was unveiled on September 10, 2019 alongside the iPhone 11 Pro at the Steve Jobs Theater in '  ||
                        'Apple Park, Cupertino, by Apple CEO Tim Cook. Preorders began on September 13, 2019, and the ' ||
                        'phone was officially released on September 20, 2019, one day after the official public release of iOS 13.', 900);