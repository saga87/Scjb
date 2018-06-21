package com.wkrj.scjdaqsc.scjdaqsc.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.wkrj.scjdaqsc.scjdaqsc.R;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.TzryczqkAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.adapter.TzsbtjpkAdapter;
import com.wkrj.scjdaqsc.scjdaqsc.entity.FirmList;
import com.wkrj.scjdaqsc.scjdaqsc.entity.firm.Ryczqk;
import com.wkrj.scjdaqsc.scjdaqsc.entity.firm.Tzsbtj;

import java.util.List;

public class FirmMessageActivity extends BaseActivity {
    private TextView tv_firm_jiben_name,tv_firm_jiben_type,tv_firm_jiben_address,tv_firm_jiben_fuzhename,tv_firm_jiben_fzphone
            ,tv_firm_jiben_guanli,tv_firm_jiben_guanliphone,tv_firm_jiben_zhigong,tv_firm_jiben_e_mail,tv_firm_jiben_mianji,
            tv_firm_jiben_guyou,tv_firm_jiben_aqgljg,tv_firm_jiben_aqgljg_name,tv_firm_jiben_aqgury,tv_firm_jiben_jyfw,tv_firm_jiben_xydm;
    private TextView tv_firm_aqsc_bianhao,tv_firm_aqsc_fzbm,tv_firm_aqsc_fzrq,tv_firm_aqsc_yxrq,tv_firm_aqsc_xkfw;
    private TextView tv_firm_aqpg_qjbgmc,tv_firm_aqpg_bjdw,tv_firm_aqpg_bjrq,tv_firm_aqpg_yxrq,tv_firm_aqpg_bjdwjb;
    private TextView tv_firm_zyws_qjbg,tv_firm_zyws_bjdw,tv_firm_zyws_qjrq,tv_firm_zyws_yxrq,tv_firm_zyws_bjdwjb;
    private TextView tv_firm_zycd_jcbgmc,tv_firm_zycd_jcdw,tv_firm_zycd_jcrq,tv_firm_zycd_yxrq,tv_firm_zycd_whys;
    private TextView tv_firm_wxhy_zsbh,tv_firm_wxhy_djrq,tv_firm_wxhy_yxrq,tv_firm_wxhy_djwx;
    private TextView tv_firm_anqbzhqk_aqbzh,tv_firm_anqbzhqk_zsbh,tv_firm_anqbzhqk_psrq,tv_firm_anqbzhqk_fsrq,tv_firm_anqbzhqk_aqbzhjb;
    private TextView tv_firm_flfjd_jcbgmc,tv_firm_flfjd_jcdw,tv_firm_flfjd_bjrq,tv_firm_flfjd_yxrq,tv_firm_flfjd_jcdsl;
    private TextView tv_firm_jczywh_sfdqtj,tv_firm_jczywh_tjrs,tv_firm_jczywh_tjrq,tv_firm_jczywh_tjhgrs,tv_firm_jczywh_yszybrs,tv_firm_jczywh_tjdw;
    private TextView tv_firm_zycdwhsb_sfwssb,tv_firm_zycdwhsb_ebhzrq,tv_firm_zycdwhsb_yxrq,tv_firm_zycdwhsb_sbhzff;
    private TextView tv_firm_zdwxy_sfgczdwxy,tv_firm_zdwxy_zdwxymc,tv_firm_zdwxy_zdwxywz,tv_firm_zdwxy_zdwxyjb,tv_firm_zdwxy_sfbzyjya,tv_firm_zdwxy_pgbgrq,
            tv_firm_zdwxy_sfba,tv_firm_zdwxy_barq,tv_firm_zdwxy_yxrq;
    private TextView tv_firm_yjyaba_zhyjya,tv_firm_yjyaba_zxyjyamc,tv_firm_yjyaba_xcclfamc,tv_firm_yjyaba_ssrq,tv_firm_yjyaba_yxrq,tv_firm_yjyaba_qsrq,
            tv_firm_yjyaba_sfba;
    private ListView list_firm_tzsbtjqk,list_firm_tzryczqk;
    private LinearLayout ll_firm_message_back;
    private FirmList firm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firm_message);

        try {
            Bundle bandle = getIntent().getExtras();
            firm = (FirmList) bandle.getSerializable("xixi");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setView();
        setListener();
        setAdapter();
    }
    private void setAdapter() {
        List<Tzsbtj> f = firm.getTzsbtjList();
        TzsbtjpkAdapter adapter = new TzsbtjpkAdapter(this,f);
        list_firm_tzsbtjqk.setAdapter(adapter);

        List<Ryczqk> s = firm.getRyczqkList();
        TzryczqkAdapter adapter1 = new TzryczqkAdapter(this,s);
        list_firm_tzryczqk.setAdapter(adapter1);
    }
    private String setData(String s) {
        String str = "";
        if(s.equals("1")){
            str = "是";
        }else {
            str = "否";
        }
        return str;
    }

    private void setListener() {
        ll_firm_message_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        try {
            //企业基本情况
            tv_firm_jiben_name.setText(firm.getEnterprise_name());
            tv_firm_jiben_type.setText(firm.getEnterprise_type()+"");
            tv_firm_jiben_address.setText(firm.getEnterprise_address());
            tv_firm_jiben_fuzhename.setText(firm.getEnterprise_dutyuser());
            tv_firm_jiben_fzphone.setText(firm.getEnterprise_dutyusertel());
            tv_firm_jiben_guanli.setText(firm.getEnterprise_aqgly());
            tv_firm_jiben_guanliphone.setText(firm.getEnterprise_aqglytel());
            tv_firm_jiben_zhigong.setText(firm.getEnterprise_zgzs()+"");
            tv_firm_jiben_e_mail.setText(firm.getEnterprise_dwyx());
            tv_firm_jiben_mianji.setText(firm.getEnterprise_zdmj());
            tv_firm_jiben_guyou.setText(firm.getEnterprise_gdzc());
            tv_firm_jiben_aqgljg.setText(setData(firm.getEnterprise_sfyaqgljg()));
            tv_firm_jiben_aqgljg_name.setText(firm.getEnterprise_aqgljgmc());
            tv_firm_jiben_aqgury.setText(setData(firm.getEnterprise_sfyzzaqgly()));
            tv_firm_jiben_jyfw.setText(firm.getEnterprise_jyfw());
            tv_firm_jiben_xydm.setText(firm.getEnterprise_tyshxydm());

            //安全生产许可证情况
            tv_firm_aqsc_bianhao.setText(firm.getAqscxkzList().get(0).getAqscxkz_aqscxkzbh());
            tv_firm_aqsc_fzbm.setText(firm.getAqscxkzList().get(0).getAqscxkz_fzbm());
            tv_firm_aqsc_fzrq.setText(firm.getAqscxkzList().get(0).getAqscxkz_fzrq());
            tv_firm_aqsc_yxrq.setText(firm.getAqscxkzList().get(0).getAqscxkz_yxrq());
            tv_firm_aqsc_xkfw.setText(firm.getAqscxkzList().get(0).getAqscxkz_xkfw());

            //安全评估报告情况
            tv_firm_aqpg_qjbgmc.setText(firm.getAqpjbgList().get(0).getAqpjbg_pjbgmc());
            tv_firm_aqpg_bjdw.setText(firm.getAqpjbgList().get(0).getAqpjbg_bzdw());
            tv_firm_aqpg_bjrq.setText(firm.getAqpjbgList().get(0).getAqpjbg_bzrq());
            tv_firm_aqpg_yxrq.setText(firm.getAqpjbgList().get(0).getAqpjbg_yxrq());
            tv_firm_aqpg_bjdwjb.setText(firm.getAqpjbgList().get(0).getAqpjbg_bzdwjb());

            //职业卫生评价报告
            tv_firm_zyws_qjbg.setText(firm.getZywspjbgList().get(0).getZywspjbg_zywspjbgmc());
            tv_firm_zyws_bjdw.setText(firm.getZywspjbgList().get(0).getZywspjbg_bzdw());
            tv_firm_zyws_qjrq.setText(firm.getZywspjbgList().get(0).getZywspjbg_bzrq());
            tv_firm_zyws_yxrq.setText(firm.getZywspjbgList().get(0).getZywspjbg_yxrq());
            tv_firm_zyws_bjdwjb.setText(firm.getZywspjbgList().get(0).getZywspjbg_bzdwjb());

            //作业场地检测情况
            tv_firm_zycd_jcbgmc.setText(firm.getZycsjcList().get(0).getZycsjc_jcbgmc());
            tv_firm_zycd_jcdw.setText(firm.getZycsjcList().get(0).getZycsjc_jcdw());
            tv_firm_zycd_jcrq.setText(firm.getZycsjcList().get(0).getZycsjc_jcrq());
            tv_firm_zycd_yxrq.setText(firm.getZycsjcList().get(0).getZycsjc_yxrq());
            tv_firm_zycd_whys.setText(firm.getZycsjcList().get(0).getZycsjc_zysjzywhys());

            //危险化学登记情况
            tv_firm_wxhy_zsbh.setText(firm.getWxhxpdjList().get(0).getWxhxpdj_zsbh());
            tv_firm_wxhy_djrq.setText(firm.getWxhxpdjList().get(0).getWxhxpdj_djrq());
            tv_firm_wxhy_yxrq.setText(firm.getWxhxpdjList().get(0).getWxhxpdj_yxrq());
            tv_firm_wxhy_djwx.setText(firm.getWxhxpdjList().get(0).getWxhxpdj_djwxhxpmc());

            //安全标准化情况
            tv_firm_anqbzhqk_aqbzh.setText(setData(firm.getAqbzhList().get(0).getAqbzh_aqbzh()));
            tv_firm_anqbzhqk_zsbh.setText(firm.getAqbzhList().get(0).getAqbzh_zsbh());
            tv_firm_anqbzhqk_psrq.setText(firm.getAqbzhList().get(0).getAqbzh_psrq());
            tv_firm_anqbzhqk_fsrq.setText(firm.getAqbzhList().get(0).getAqbzh_fsrq());
            tv_firm_anqbzhqk_aqbzhjb.setText(firm.getAqbzhList().get(0).getAqbzh_aqbzhjb());

            //防雷防静电检测情况
            tv_firm_flfjd_jcbgmc.setText(firm.getFlfjdjcList().get(0).getFlfjdjc_jcbbmc());
            tv_firm_flfjd_jcdw.setText(firm.getFlfjdjcList().get(0).getFlfjdjc_jcdw());
            tv_firm_flfjd_bjrq.setText(firm.getFlfjdjcList().get(0).getFlfjdjc_bzrq());
            tv_firm_flfjd_yxrq.setText(firm.getFlfjdjcList().get(0).getFlfjdjc_yxrq());
            tv_firm_flfjd_jcdsl.setText(firm.getFlfjdjcList().get(0).getFlfjdjc_jcdsl());

            //接触职业危害人体体检情况
            tv_firm_jczywh_sfdqtj.setText(setData(firm.getJczywhrytjList().get(0).getJczywhrytj_sfdqtj()));
            tv_firm_jczywh_tjrs.setText(firm.getJczywhrytjList().get(0).getJczywhrytj_tjrs()+"");
            tv_firm_jczywh_tjrq.setText(firm.getJczywhrytjList().get(0).getJczywhrytj_tjrq());
            tv_firm_jczywh_tjhgrs.setText(firm.getJczywhrytjList().get(0).getJczywhrytj_tjhgrs()+"");
            tv_firm_jczywh_yszybrs.setText(firm.getJczywhrytjList().get(0).getJczywhrytj_yszybrs()+"");
            tv_firm_jczywh_tjdw.setText(firm.getJczywhrytjList().get(0).getJczywhrytj_tjdw());

            //作业场地危害申报情况
            tv_firm_zycdwhsb_sfwssb.setText(setData(firm.getZycszywhsbList().get(0).getZycszywhsb_sfwssb()));
            tv_firm_zycdwhsb_ebhzrq.setText(firm.getZycszywhsbList().get(0).getZycszywhsb_sbhzrq());
            tv_firm_zycdwhsb_yxrq.setText(firm.getZycszywhsbList().get(0).getZycszywhsb_yxrq());
            tv_firm_zycdwhsb_sbhzff.setText(firm.getZycszywhsbList().get(0).getZycszywhsb_sbhzffdw());

            //重大危险源情况
            tv_firm_zdwxy_sfgczdwxy.setText(setData(firm.getZdwxyList().get(0).getZdwxy_sfgczdwxy()));
            tv_firm_zdwxy_zdwxymc.setText(firm.getZdwxyList().get(0).getZdwxy_zdwxymc());
            tv_firm_zdwxy_zdwxywz.setText(firm.getZdwxyList().get(0).getZdwxy_zdwxywz());
            tv_firm_zdwxy_zdwxyjb.setText(firm.getZdwxyList().get(0).getZdwxy_zdwxydj());
            tv_firm_zdwxy_sfbzyjya.setText(firm.getZdwxyList().get(0).getZdwxy_sfbzyjya());
            tv_firm_zdwxy_pgbgrq.setText(firm.getZdwxyList().get(0).getZdwxy_pgbgrq());
            tv_firm_zdwxy_sfba.setText(setData(firm.getZdwxyList().get(0).getZdwxy_sfba()));
            tv_firm_zdwxy_barq.setText(firm.getZdwxyList().get(0).getZdwxy_barq());
            tv_firm_zdwxy_yxrq.setText(firm.getZdwxyList().get(0).getZdwxy_yxrq());

            //应急预案备案情况
            tv_firm_yjyaba_zhyjya.setText(firm.getYjyabaList().get(0).getYjyaba_zhyjyamc());
            tv_firm_yjyaba_zxyjyamc.setText(firm.getYjyabaList().get(0).getYjyaba_zxyjyamc());
            tv_firm_yjyaba_xcclfamc.setText(firm.getYjyabaList().get(0).getYjyaba_xcczfamc());
            tv_firm_yjyaba_ssrq.setText(firm.getYjyabaList().get(0).getYjyaba_ssrq());
            tv_firm_yjyaba_yxrq.setText(firm.getYjyabaList().get(0).getYjyaba_yxrq());
            tv_firm_yjyaba_qsrq.setText(firm.getYjyabaList().get(0).getYjyaba_psrq());
            tv_firm_yjyaba_sfba.setText(setData(firm.getYjyabaList().get(0).getYjyaba_sfba()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setView() {

        ll_firm_message_back = (LinearLayout) findViewById(R.id.ll_firm_message_back);

        list_firm_tzsbtjqk = (ListView) findViewById(R.id.list_firm_tzsbtjqk);
        list_firm_tzryczqk = (ListView) findViewById(R.id.list_firm_tzryczqk);
        //应急预案备案情况
        tv_firm_yjyaba_zhyjya = (TextView) findViewById(R.id.tv_firm_yjyaba_zhyjya);
        tv_firm_yjyaba_zxyjyamc = (TextView) findViewById(R.id.tv_firm_yjyaba_zxyjyamc);
        tv_firm_yjyaba_xcclfamc = (TextView) findViewById(R.id.tv_firm_yjyaba_xcclfamc);
        tv_firm_yjyaba_ssrq = (TextView) findViewById(R.id.tv_firm_yjyaba_ssrq);
        tv_firm_yjyaba_yxrq = (TextView) findViewById(R.id.tv_firm_yjyaba_yxrq);
        tv_firm_yjyaba_qsrq = (TextView) findViewById(R.id.tv_firm_yjyaba_qsrq);
        tv_firm_yjyaba_sfba = (TextView) findViewById(R.id.tv_firm_yjyaba_sfba);
        //重大危险源情况
        tv_firm_zdwxy_sfgczdwxy = (TextView) findViewById(R.id.tv_firm_zdwxy_sfgczdwxy);
        tv_firm_zdwxy_zdwxymc = (TextView) findViewById(R.id.tv_firm_zdwxy_zdwxymc);
        tv_firm_zdwxy_zdwxywz = (TextView) findViewById(R.id.tv_firm_zdwxy_zdwxywz);
        tv_firm_zdwxy_zdwxyjb = (TextView) findViewById(R.id.tv_firm_zdwxy_zdwxyjb);
        tv_firm_zdwxy_sfbzyjya = (TextView) findViewById(R.id.tv_firm_zdwxy_sfbzyjya);
        tv_firm_zdwxy_pgbgrq = (TextView) findViewById(R.id.tv_firm_zdwxy_pgbgrq);
        tv_firm_zdwxy_sfba = (TextView) findViewById(R.id.tv_firm_zdwxy_sfba);
        tv_firm_zdwxy_barq = (TextView) findViewById(R.id.tv_firm_zdwxy_barq);
        tv_firm_zdwxy_yxrq = (TextView) findViewById(R.id.tv_firm_zdwxy_yxrq);
        //作业场地危害申报情况
        tv_firm_zycdwhsb_sfwssb = (TextView) findViewById(R.id.tv_firm_zycdwhsb_sfwssb);
        tv_firm_zycdwhsb_ebhzrq = (TextView) findViewById(R.id.tv_firm_zycdwhsb_ebhzrq);
        tv_firm_zycdwhsb_yxrq = (TextView) findViewById(R.id.tv_firm_zycdwhsb_yxrq);
        tv_firm_zycdwhsb_sbhzff = (TextView) findViewById(R.id.tv_firm_zycdwhsb_sbhzff);
        //接触职业危害人体体检情况
        tv_firm_jczywh_sfdqtj = (TextView) findViewById(R.id.tv_firm_jczywh_sfdqtj);
        tv_firm_jczywh_tjrs = (TextView) findViewById(R.id.tv_firm_jczywh_tjrs);
        tv_firm_jczywh_tjrq = (TextView) findViewById(R.id.tv_firm_jczywh_tjrq);
        tv_firm_jczywh_tjhgrs = (TextView) findViewById(R.id.tv_firm_jczywh_tjhgrs);
        tv_firm_jczywh_yszybrs = (TextView) findViewById(R.id.tv_firm_jczywh_yszybrs);
        tv_firm_jczywh_tjdw = (TextView) findViewById(R.id.tv_firm_jczywh_tjdw);
        //防雷防静电检测情况
        tv_firm_flfjd_jcbgmc = (TextView) findViewById(R.id.tv_firm_flfjd_jcbgmc);
        tv_firm_flfjd_jcdw = (TextView) findViewById(R.id.tv_firm_flfjd_jcdw);
        tv_firm_flfjd_bjrq = (TextView) findViewById(R.id.tv_firm_flfjd_bjrq);
        tv_firm_flfjd_yxrq = (TextView) findViewById(R.id.tv_firm_flfjd_yxrq);
        tv_firm_flfjd_jcdsl = (TextView) findViewById(R.id.tv_firm_flfjd_jcdsl);
        //安全标准化情况
        tv_firm_anqbzhqk_aqbzh = (TextView) findViewById(R.id.tv_firm_anqbzhqk_aqbzh);
        tv_firm_anqbzhqk_zsbh = (TextView) findViewById(R.id.tv_firm_anqbzhqk_zsbh);
        tv_firm_anqbzhqk_psrq = (TextView) findViewById(R.id.tv_firm_anqbzhqk_psrq);
        tv_firm_anqbzhqk_fsrq = (TextView) findViewById(R.id.tv_firm_anqbzhqk_fsrq);
        tv_firm_anqbzhqk_aqbzhjb = (TextView) findViewById(R.id.tv_firm_anqbzhqk_aqbzhjb);
        //危险化学登记情况
        tv_firm_wxhy_zsbh = (TextView) findViewById(R.id.tv_firm_wxhy_zsbh);
        tv_firm_wxhy_djrq = (TextView) findViewById(R.id.tv_firm_wxhy_djrq);
        tv_firm_wxhy_yxrq = (TextView) findViewById(R.id.tv_firm_wxhy_yxrq);
        tv_firm_wxhy_djwx = (TextView) findViewById(R.id.tv_firm_wxhy_djwx);
        //作业场地检测情况
        tv_firm_zycd_jcbgmc = (TextView) findViewById(R.id.tv_firm_zycd_jcbgmc);
        tv_firm_zycd_jcdw = (TextView) findViewById(R.id.tv_firm_zycd_jcdw);
        tv_firm_zycd_jcrq = (TextView) findViewById(R.id.tv_firm_zycd_jcrq);
        tv_firm_zycd_yxrq = (TextView) findViewById(R.id.tv_firm_zycd_yxrq);
        tv_firm_zycd_whys = (TextView) findViewById(R.id.tv_firm_zycd_whys);
        //职业卫生评价报告
        tv_firm_zyws_qjbg = (TextView) findViewById(R.id.tv_firm_zyws_qjbg);
        tv_firm_zyws_bjdw = (TextView) findViewById(R.id.tv_firm_zyws_bjdw);
        tv_firm_zyws_qjrq = (TextView) findViewById(R.id.tv_firm_zyws_qjrq);
        tv_firm_zyws_yxrq = (TextView) findViewById(R.id.tv_firm_zyws_yxrq);
        tv_firm_zyws_bjdwjb = (TextView) findViewById(R.id.tv_firm_zyws_bjdwjb);
        //安全评估报告情况
        tv_firm_aqpg_qjbgmc = (TextView) findViewById(R.id.tv_firm_aqpg_qjbgmc);
        tv_firm_aqpg_bjdw = (TextView) findViewById(R.id.tv_firm_aqpg_bjdw);
        tv_firm_aqpg_bjrq = (TextView) findViewById(R.id.tv_firm_aqpg_bjrq);
        tv_firm_aqpg_yxrq = (TextView) findViewById(R.id.tv_firm_aqpg_yxrq);
        tv_firm_aqpg_bjdwjb = (TextView) findViewById(R.id.tv_firm_aqpg_bjdwjb);
        //安全生产许可证情况
        tv_firm_aqsc_bianhao = (TextView) findViewById(R.id.tv_firm_aqsc_bianhao);
        tv_firm_aqsc_fzbm = (TextView) findViewById(R.id.tv_firm_aqsc_fzbm);
        tv_firm_aqsc_fzrq = (TextView) findViewById(R.id.tv_firm_aqsc_fzrq);
        tv_firm_aqsc_yxrq = (TextView) findViewById(R.id.tv_firm_aqsc_yxrq);
        tv_firm_aqsc_xkfw = (TextView) findViewById(R.id.tv_firm_aqsc_xkfw);
        //企业基本情况
        tv_firm_jiben_name = (TextView) findViewById(R.id.tv_firm_jiben_name);
        tv_firm_jiben_type = (TextView) findViewById(R.id.tv_firm_jiben_type);
        tv_firm_jiben_address = (TextView) findViewById(R.id.tv_firm_jiben_address);
        tv_firm_jiben_fuzhename = (TextView) findViewById(R.id.tv_firm_jiben_fuzhename);
        tv_firm_jiben_fzphone = (TextView) findViewById(R.id.tv_firm_jiben_fzphone);
        tv_firm_jiben_guanli = (TextView) findViewById(R.id.tv_firm_jiben_guanli);
        tv_firm_jiben_guanliphone = (TextView) findViewById(R.id.tv_firm_jiben_guanliphone);
        tv_firm_jiben_zhigong = (TextView) findViewById(R.id.tv_firm_jiben_zhigong);
        tv_firm_jiben_e_mail = (TextView) findViewById(R.id.tv_firm_jiben_e_mail);
        tv_firm_jiben_mianji = (TextView) findViewById(R.id.tv_firm_jiben_mianji);
        tv_firm_jiben_guyou = (TextView) findViewById(R.id.tv_firm_jiben_guyou);
        tv_firm_jiben_aqgljg = (TextView) findViewById(R.id.tv_firm_jiben_aqgljg);
        tv_firm_jiben_aqgljg_name = (TextView) findViewById(R.id.tv_firm_jiben_aqgljg_name);
        tv_firm_jiben_aqgury = (TextView) findViewById(R.id.tv_firm_jiben_aqgury);
        tv_firm_jiben_jyfw = (TextView) findViewById(R.id.tv_firm_jiben_jyfw);
        tv_firm_jiben_xydm = (TextView) findViewById(R.id.tv_firm_jiben_xydm);
    }
}
