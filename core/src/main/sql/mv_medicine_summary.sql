create MATERIALIZED VIEW mv_medicine_summary
(medicine_id, medicine_title, view_count, main_img_src, inn_id, manufacturer_name)
AS
select core.id,
  core.tradenamename,
  core.tradenameviewcount,
  det.main_img_src,
  det.inn_id,
  case
    when man.manufacturername_ru is not null then man.manufacturername_ru
    else man.manufacturername_en
  END
from medicine_info_core core
  join medicine_info_details det on det.id = core.details_id
  join manufacturer man on det.manufacturer_id = man.manufacturerid;

-- indices
CREATE INDEX mv_medicine_summary_med_id_idx
ON mv_medicine_summary (medicine_id);

CREATE INDEX mv_medicine_summary_med_title_idx
on mv_medicine_summary (medicine_title);