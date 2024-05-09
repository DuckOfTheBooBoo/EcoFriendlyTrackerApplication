delimiter //
create function get_sub_category_id(sub_cat_name varchar(255)) RETURNS INT deterministic
begin
	declare sub_cat_id INT;
    
    select sub_category_id
    into sub_cat_id
    from sub_category
    where sub_category_name = sub_cat_name
    collate utf8mb4_general_ci;
    
    if sub_cat_id is null then
		set sub_cat_id = 0;
    end if;
    return sub_cat_id;
end//
delimiter ;
