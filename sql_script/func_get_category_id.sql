delimiter //
create function get_category_id(cat_name varchar(255)) RETURNS INT deterministic
begin
	declare cat_id INT;
    
    select category_id
    into cat_id
    from category
    where category_name = cat_name
    collate utf8mb4_general_ci;
    
    if cat_id is null then
		set cat_id = 0;
    end if;
    return cat_id;
end//
delimiter ;
