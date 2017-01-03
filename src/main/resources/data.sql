delete from follow;
INSERT INTO `follow` (`id`, `create_date`, `target_id`, `version`) VALUES
	(1, '2017-01-03 05:18:33', 2, 0),
	(2, '2017-01-03 05:18:51', 2, 0);

delete from person;
INSERT INTO `person` (`user_id`, `name`) VALUES
	(1, '1'),
	(2, '2');

delete from post;
INSERT INTO `post` (`id`, `contents`, `create_date`, `modify_date`, `title`, `user_id`, `version`) VALUES
	(1, 'contents', '2017-01-03 05:18:30', '2017-01-03 05:18:30', 'title', 2, 0),
	(2, 'contents', '2017-01-03 05:18:31', '2017-01-03 05:18:31', 'title', 1, 0);