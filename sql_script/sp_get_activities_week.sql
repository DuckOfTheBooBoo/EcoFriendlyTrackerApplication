DELIMITER //
CREATE PROCEDURE get_activities_week(IN start_date DATE, IN end_date DATE)
BEGIN
	SELECT 
		activity_id, 
		category_name, 
		sub_category_name, 
		specific_cat_name,
		calculation_metric,
		emission_total
	FROM activity ac
	JOIN category c ON c.category_id = ac.category_id
	JOIN sub_category sc ON sc.sub_category_id = ac.sub_category_id
	JOIN specific_category spc ON spc.specific_cat_id = ac.specific_cat_id
    WHERE date_created BETWEEN start_date AND end_date;
END//
DELIMITER ;
