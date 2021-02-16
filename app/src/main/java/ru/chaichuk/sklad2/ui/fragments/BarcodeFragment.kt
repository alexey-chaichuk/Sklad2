package ru.chaichuk.sklad2.ui.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.device.ScanManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.chaichuk.sklad2.R
import ru.chaichuk.sklad2.ui.viewModels.BarcodeViewModel
import ru.chaichuk.sklad2.ui.viewModels.BarcodeViewModelFactory

class BarcodeFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: BarcodeViewModel by viewModels { BarcodeViewModelFactory() }

    private var tvMessage : TextView? = null

    private val SCAN_ACTION = "urovo.rcv.message"
    private var mScanManager: ScanManager? = null
    private var isScaning = false
    private var barcodeStr = "---"
    private var barcodeType: Byte = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvMessage = view.findViewById(R.id.message)
    }

    override fun onResume() {
        super.onResume()
        initScan()
        //showScanResult.setText("");
        //showScanResult.setText("");
        val filter = IntentFilter()
        filter.addAction(SCAN_ACTION)
        requireActivity().registerReceiver(mScanReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        mScanManager?.let {
            it.stopDecode()
            isScaning = false
            requireActivity().unregisterReceiver(mScanReceiver)
        }
    }

    private fun initScan() {
        mScanManager = ScanManager()
        mScanManager?.let {
            it.openScanner()
            it.switchOutputMode(0)
            //soundpool = new SoundPool(1, AudioManager.STREAM_NOTIFICATION, 100); // MODE_RINGTONE
            //soundid = soundpool.load("/etc/Scan_new.ogg", 1);
        }
    }

    private val mScanReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            isScaning = false
            //soundpool.play(soundid, 1, 1, 0, 0, 1);
            //showScanResult.setText("");
            //mVibrator.vibrate(100);
            val barcode = intent.getByteArrayExtra("barcode")
            val barcodelen = intent.getIntExtra("length", 0)
            barcodeType = intent.getByteExtra(
                "barcodeType",
                0.toByte()
            )
            Log.i("barcode", "----codetype-- ${barcodeType}")
            barcodeStr = String(barcode!!, 0, barcodelen)
            Log.i("barcode", barcodeStr)
            tvMessage?.setText(barcodeStr)
            /*tvBarcodeType.setText("type: " + ru.momentum.sklad.AddBarcodeActivity.barcodeType)
            addThisBarcode.setEnabled(true)*/

//            Intent intentBarcodeSearchResp = new Intent(context, BarcodeSearchRespActivity.class);
//            intentBarcodeSearchResp.putExtra("barcode", barcodeStr);
//            intentBarcodeSearchResp.putExtra("barcodeType", barcodeType);
//            context.startActivity(intentBarcodeSearchResp);
        }
    }

}
