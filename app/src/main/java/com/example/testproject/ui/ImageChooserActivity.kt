package com.example.testproject.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.databinding.ActivityImageChooserBinding
import com.example.testproject.utils.RequestCodes
import java.io.FileNotFoundException
import java.io.IOException

class ImageChooserActivity : AppCompatActivity() {

    private var binding: ActivityImageChooserBinding? = null
    private val mBinding get() = binding!!

    companion object {

        private val REQUEST_CODE = RequestCodes.CHOOSE_IMAGE_FROM_GALLERY.getCode()

        fun newIntent(packageContext: Context): Intent {

            return Intent(packageContext, ImageChooserActivity::class.java)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageChooserBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        mBinding.btnPickImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            if (data != null && data.data != null) {

                val uri = data.data
                try {

                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                    mBinding.ivImage.setImageBitmap(bitmap)
                    mBinding.tvUri.text = uri?.path

                } catch (e: FileNotFoundException) {

                    e.printStackTrace()

                } catch (e: IOException) {

                    e.printStackTrace()

                }

            }

        }

    }

}