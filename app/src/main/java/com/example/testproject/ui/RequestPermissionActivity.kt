package com.example.testproject.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.request.ExplainScope
import com.permissionx.guolindev.request.ForwardScope


class RequestPermissionActivity : AppCompatActivity() {

    companion object {

        fun newIntent(packageContext: Context): Intent {

            return Intent(packageContext, RequestPermissionActivity::class.java)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_permission)

        val btnRequestPermission: Button = findViewById(R.id.btn_request_permission)
        btnRequestPermission.setOnClickListener { view ->

            val permissions = listOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )

            requestPermissions(permissions)

        }

        val btnKeepRequestingPermission: Button = findViewById(R.id.btn_keep_requesting_permission)
        btnKeepRequestingPermission.setOnClickListener { view ->

            val permissions = listOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )

            keepRequestingPermissions(permissions)

        }

    }

    private fun requestPermissions(permissions: List<String>) {

        PermissionX.init(this)
            .permissions(permissions)
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(
                        this,
                        "These permissions are denied: $deniedList",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

    }

    private fun keepRequestingPermissions(permissions: List<String>) {
        PermissionX.init(this)
            .permissions(permissions)
            .explainReasonBeforeRequest()
            .onExplainRequestReason { scope: ExplainScope, deniedList: List<String>, beforeRequest: Boolean ->

                scope.showRequestReasonDialog(
                    deniedList,
                    "PermissionX needs following permissions to continue",
                    "Allow",
                    "Deny"
                )

            }
            .onForwardToSettings { scope: ForwardScope, deniedList: List<String> ->
                scope.showForwardToSettingsDialog(
                    deniedList,
                    "Please allow following permissions in settings",
                    "Allow",
                    "Deny"
                )
            }
            .request { allGranted: Boolean, grantedList: List<String>, deniedList: List<String> ->
                if (allGranted) {
                    Toast.makeText(
                        this, "All permissions are granted", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "The following permissions are denied：$deniedList",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}