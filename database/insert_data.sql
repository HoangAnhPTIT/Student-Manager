INSERT INTO `studentmanager`.`user` (`id`, `address`, `age`, `fullname`, `gender`, `password`, `username`) VALUES ('1', 'Nghe An', '20', 'Cao Hoang Anh', 'Nam', '123456', 'hoanganh');
INSERT INTO `studentmanager`.`user` (`id`, `address`, `age`, `fullname`, `gender`, `password`, `username`) VALUES ('2', 'Ha Noi', '20', 'Pham Quoc Khanh', 'Nam', '123456', 'khanh');
INSERT INTO `studentmanager`.`user` (`id`, `address`, `age`, `fullname`, `gender`, `password`, `username`) VALUES ('3', 'Nghe An', '20', 'Pham Hai Nam', 'Nam', '123456', 'hainam');
INSERT INTO `studentmanager`.`user` (`id`, `address`, `age`, `fullname`, `gender`, `password`, `username`) VALUES ('4', 'Nghe An', '20', 'Nguyen Quynh Mai', 'Nu', '123456', 'quynhmai');
INSERT INTO `studentmanager`.`user` (`id`, `address`, `age`, `fullname`, `gender`, `password`, `username`) VALUES ('5', 'Ha Noi', '40', 'Nguyen Manh Son', 'Nam ', '123456', 'manhson');

SELECT @@GLOBAL.sql_mode global, @@SESSION.sql_mode session;
SET sql_mode = '';
SET GLOBAL sql_mode = '';

INSERT INTO `studentmanager`.`role` (`id`, `code`, `name`) VALUES ('1', 'ADMIN', 'Quan-Tri');
INSERT INTO `studentmanager`.`role` (`id`, `code`, `name`) VALUES ('2', 'USER', 'Nguoi-Dung');


INSERT INTO `studentmanager`.`user_role` (`user_id`, `role_id`, `id`) VALUES ('1', '1', '1');
INSERT INTO `studentmanager`.`user_role` (`user_id`, `role_id`, `id`) VALUES ('2', '2', '2');
INSERT INTO `studentmanager`.`user_role` (`user_id`, `role_id`, `id`) VALUES ('3', '2', '3');
INSERT INTO `studentmanager`.`user_role` (`user_id`, `role_id`, `id`) VALUES ('4', '2', '4');

INSERT INTO `studentmanager`.`teacher` (`id`, `experience`, `salary`, `subject`, `exam_id`, `user_id`) VALUES ('1', '3', '10', 'CTDL', '', '5');


INSERT INTO `studentmanager`.`subject` (`id`, `name`, `numberofcertificate`, `studentpersubject`) VALUES ('1', 'CSDL', '3', '60');
	
INSERT INTO `studentmanager`.`exam` (`id`, `date`, `result`, `student_id`, `subject_id`) VALUES ('1', '2/3/2020', '12', '2', '1');

INSERT INTO `studentmanager`.`student` (`id`, `user_id`) VALUES ('1', '1');
INSERT INTO `studentmanager`.`student` (`id`, `user_id`) VALUES ('2', '2');
INSERT INTO `studentmanager`.`student` (`id`, `user_id`) VALUES ('3', '3');
INSERT INTO `studentmanager`.`student` (`id`, `user_id`) VALUES ('4', '4');
